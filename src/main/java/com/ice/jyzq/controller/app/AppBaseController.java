package com.ice.jyzq.controller.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ice.jyzq.service.app.TokenService;

@Component
public class AppBaseController {

	@Autowired
	TokenService tokenService;

	String getUserNameFromToken(String token) {
		return tokenService.getUserNameFromToken(token);
	}

}
