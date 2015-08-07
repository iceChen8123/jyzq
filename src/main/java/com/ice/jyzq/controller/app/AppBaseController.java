package com.ice.jyzq.controller.app;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ice.jyzq.service.app.TokenService;

@Component
public class AppBaseController {

	@Autowired
	TokenService tokenService;

	boolean isRightToken(HttpServletRequest request, String token) {
		return TokenUtil.isRightToken(request, token);
	}

}
