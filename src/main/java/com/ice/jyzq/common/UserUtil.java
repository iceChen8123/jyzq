package com.ice.jyzq.common;

import org.apache.shiro.SecurityUtils;

public class UserUtil {

	public static String getCurrentUserName() {
		return SecurityUtils.getSubject().getPrincipal().toString();
	}
}
