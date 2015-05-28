package com.ice.jyzq.common;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ice.jyzq.service.UserService;
import com.ice.server.bean.User;

@Component
public class UserUtil {

	@Autowired
	private UserService userService;

	public String getCurrentUserName() {
		if (SecurityUtils.getSubject().getPrincipal() != null) {
			return SecurityUtils.getSubject().getPrincipal().toString();
		} else {
			return "";
		}
	}

	public User getUser() {
		return userService.findByUserName(getCurrentUserName());
	}

}
