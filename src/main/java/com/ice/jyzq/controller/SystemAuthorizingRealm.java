package com.ice.jyzq.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 系统安全认证实现类
 */
@Service
public class SystemAuthorizingRealm extends AuthorizingRealm {

	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	protected Logger logger = LoggerFactory.getLogger(getClass());

	public SystemAuthorizingRealm() {
		super(new MemoryConstrainedCacheManager());
		logger.info("SystemAuthorizingRealm yi ci........................");
	}

	/**
	 * 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;

		byte[] salt = "test".getBytes();
		// if (LoginController.isValidateCodeLogin(token.getUsername(), false,
		// false)) {
		// // 判断验证码
		// Session session = SecurityUtils.getSubject().getSession();
		// String code = (String)
		// session.getAttribute(ValidateCodeServlet.VALIDATE_CODE);
		// if (token.getCaptcha() == null ||
		// !token.getCaptcha().toUpperCase().equals(code)) {
		// throw new CaptchaException("验证码错误.");
		// }
		// }
		//
		// if ("admin".equalsIgnoreCase(token.getUsername())) { // admin用户通过
		// User user =
		// getSystemService().getUserByLoginName(token.getUsername());
		// if (user != null) {
		// byte[] salt = Encodes.decodeHex(user.getPassword().substring(0, 16));
		// // 若存在，将此用户存放到登录认证info中
		// return new SimpleAuthenticationInfo(new Principal(user),
		// user.getPassword().substring(16),
		// ByteSource.Util.bytes(salt), getName());
		// } else {
		// return null;
		// }
		// }
		//
		// if ("admin1".equalsIgnoreCase(token.getUsername())) { // admin用户通过
		// // 数据库密码验证
		// User user =
		// getSystemService().getUserByLoginName(token.getUsername());
		// if (user != null) {
		// byte[] salt = Encodes.decodeHex(user.getPassword().substring(0, 16));
		// // 若存在，将此用户存放到登录认证info中
		// return new SimpleAuthenticationInfo(new Principal(user),
		// user.getPassword().substring(16),
		// ByteSource.Util.bytes(salt), getName());
		// } else {
		// return null;
		// }
		// }
		//
		// User user =
		// getSystemService().getUserByLoginName(token.getUsername());
		// if (user == null) {
		// logger.error(token.getUsername() + "用户不存在。需要先添加用户");
		// throw new RuntimeException("用户不存在。");
		// }
		//
		// logger.info("begin offlineAPI.authPortalExecute !");
		// AuthPortalExecuteResponse rsp = null;
		// try {
		// rsp = offlineAPI.authPortalExecute(token.getUsername(), new
		// String(token.getPassword()), token.getHost(),
		// token.getDcname());
		// } catch (Exception e) {
		// throw new RuntimeException(e);
		// }
		// logger.info("end offlineAPI.authPortalExecute !");
		// if (null == rsp) {
		// logger.error("[Offline登陆权限验证接口调用失败]空应答");
		// throw new RuntimeException("[Offline登陆权限验证接口调用失败]空应答");
		// }
		// ResponseHeader header = rsp.getResponseHeader();
		// if (null == header || !"Success".equals(header.getResultCode())) {
		// logger.error("[Offline登陆权限验证接口调用失败]code:" + header.getResultCode());
		// throw new RuntimeException("[Offline登陆权限验证接口调用失败]code:" +
		// header.getResultCode());
		// }
		// if (1001 != rsp.getReturnCode()) {
		// logger.error("[Offline登陆权限验证接口调用失败]code:" + rsp.getReturnCode());
		// throw new RuntimeException("[Offline登陆权限验证接口调用失败]code:" +
		// rsp.getReturnCode());
		// }
		//
		// token.setPassword("123456".toCharArray());
		// byte[] salt = Encodes.decodeHex(user.getPassword().substring(0, 16));
		// 若存在，将此用户存放到登录认证info中
		return new SimpleAuthenticationInfo(new Principal(), "password22222222222222222".substring(16),
				ByteSource.Util.bytes(salt), getName());
	}

	/**
	 * 授权认证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		return info;
	}

	/**
	 * 设定密码校验的Hash算法与迭代次数
	 */
	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(HASH_ALGORITHM);
		matcher.setHashIterations(HASH_INTERATIONS);
		setCredentialsMatcher(matcher);
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

	/**
	 * 授权用户信息
	 */
	public static class Principal implements Serializable {

		private static final long serialVersionUID = 1L;

		private Integer id;
		private String loginName;
		private String name;
		private Map<String, Object> cacheMap;

		// private User user;

		// public Principal(User user) {
		// this.id = user.getId();
		// this.loginName = user.getLoginName();
		// this.name = user.getName();
		// this.user = user;
		// }

		public Integer getId() {
			return id;
		}

		public String getLoginName() {
			return loginName;
		}

		public String getName() {
			return name;
		}

		public Map<String, Object> getCacheMap() {
			if (cacheMap == null) {
				cacheMap = new HashMap<String, Object>();
			}
			return cacheMap;
		}

	}
}
