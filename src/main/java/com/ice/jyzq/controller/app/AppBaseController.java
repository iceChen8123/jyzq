package com.ice.jyzq.controller.app;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ice.jyzq.service.app.TokenService;

@Component
public class AppBaseController {

	@Autowired
	TokenService tokenService;

	HeaderInfo getHeaderInfo(HttpServletRequest request) {
		HeaderInfo headerInfo = new HeaderInfo();
		headerInfo.setImei(request.getHeader("imei"));
		headerInfo.setModel(request.getHeader("model"));
		headerInfo.setUuid(request.getHeader("uuid"));
		headerInfo.setVendor(request.getHeader("vendor"));
		return headerInfo;
	}

	boolean isRightToken(HttpServletRequest request, String token) {
		HeaderInfo headerInfo = getHeaderInfo(request);
		return token.equals(TokenUtil.genToken(headerInfo));
	}

}
