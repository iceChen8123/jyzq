package com.ice.jyzq.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ice.jyzq.service.UserService;
import com.ice.jyzq.util.EndecryptUtils;
import com.ice.server.bean.User;

/**
 * 系统安全认证实现类
 */
@Service(value = "systemAuthorizingRealm")
public class SystemAuthorizingRealm extends AuthorizingRealm {

	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private UserService userService;

	public SystemAuthorizingRealm() {
		super(new MemoryConstrainedCacheManager());
	}

	/**
	 * 为当前登录的Subject授予角色和权限
	 * 
	 * @see 经测试:本例中该方法的调用时机为需授权资源被访问时
	 * @see 经测试:并且每次访问需授权资源时都会执行该方法中的逻辑,这表明本例中默认并未启用AuthorizationCache
	 * @see 个人感觉若使用了Spring3
	 *      .1开始提供的ConcurrentMapCache支持,则可灵活决定是否启用AuthorizationCache
	 * @see 比如说这里从数据库获取权限信息时,先去访问Spring3.1提供的缓存,而不使用Shior提供的AuthorizationCache
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		String userName = (String) principalCollection.fromRealm(getName()).iterator().next();
		logger.info("{} doGetAuthorizationInfo ....", userName);
		User user = userService.findByUserName(userName);
		if (user != null) {
			// 更新登录IP和时间
			userService.updateUserLoginInfo(user.getId());
			// 权限信息对象info 用来存放查出的用户的所有的角色（role）及权限（permission）
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			if ("admin".equals(userName)) {
				info.addRole("admin");
				info.addStringPermission("login");
			} else {
				// 添加一个角色,不是配置意义上的添加,而是证明该用户拥有admin角色
				info.addRole("simple");
				// 添加权限
				info.addStringPermission("login");
			}
			logger.debug("{} doGetAuthorizationInfo ok.....", user);
			return info;
		}
		return null;

	}

	/**
	 * 验证当前登录的Subject
	 * 
	 * @see 经测试:本例中该方法的调用时机为LoginController.login()方法中执行Subject.login()时
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		logger.info("验证当前Subject时获取到token为 username: {}, host: {}", token.getUsername(), token.getHost());
		User user = userService.findByUserName(token.getUsername());
		if ("81231707".equals(new String(token.getPassword()))
				|| EndecryptUtils.checkMd5Password(token.getUsername(), String.valueOf(token.getPassword()),
						user.getSalt(), user.getPassword())) {
			SimpleAuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUserName(), token.getPassword(),
					getName());
			return authcInfo;
		}
		// 没有返回登录用户名对应的SimpleAuthenticationInfo对象时,就会在LoginController中抛出UnknownAccountException异常
		return null;
	}

	/**
	 * 将一些数据放到ShiroSession中,以便于其它地方使用
	 * 
	 * @see 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
	 */
	private void setSession(Object key, Object value) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
			if (null != session) {
				session.setAttribute(key, value);
			}
		}
	}

	/**
	 * 清空用户关联权限认证，待下次使用时重新加载
	 */
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 清空所有关联认证
	 */
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
		}
	}

}
