package com.ice.jyzq.controller;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;
import com.ice.jyzq.controller.SystemAuthorizingRealm.Principal;
import com.ice.server.bean.User;
import com.ice.server.dao.UserDao;

/**
 * 用户工具类
 */
@Component
public class UserUtils {

	public static final String CACHE_USER = "user";
	public static final String CACHE_ROLE_LIST = "roleList";
	public static final String CACHE_MENU_LIST = "menuList";
	public static final String CACHE_AREA_LIST = "areaList";
	public static final String CACHE_OFFICE_LIST = "officeList";

	@Autowired
	private UserDao userDao;

	public User getUser() {
		User user = (User) getCache(CACHE_USER);
		if (user == null) {
			try {
				Subject subject = SecurityUtils.getSubject();
				Principal principal = (Principal) subject.getPrincipal();
				if (principal != null) {
					user = userDao.findOne(principal.getId());
					putCache(CACHE_USER, user);
				}
			} catch (UnavailableSecurityManagerException e) {

			} catch (InvalidSessionException e) {

			}
		}
		if (user == null) {
			user = new User();
			try {
				SecurityUtils.getSubject().logout();
			} catch (UnavailableSecurityManagerException e) {

			} catch (InvalidSessionException e) {

			}
		}
		return user;
	}

	// ============== User Cache ==============

	public static Object getCache(String key) {
		return getCache(key, null);
	}

	public static Object getCache(String key, Object defaultValue) {
		Object obj = getCacheMap().get(key);
		return obj == null ? defaultValue : obj;
	}

	public static void putCache(String key, Object value) {
		getCacheMap().put(key, value);
	}

	public static void removeCache(String key) {
		getCacheMap().remove(key);
	}

	public static Map<String, Object> getCacheMap() {
		Map<String, Object> map = Maps.newHashMap();
		try {
			Subject subject = SecurityUtils.getSubject();
			Principal principal = (Principal) subject.getPrincipal();
			return principal != null ? principal.getCacheMap() : map;
		} catch (UnavailableSecurityManagerException e) {

		} catch (InvalidSessionException e) {

		}
		return map;
	}

}
