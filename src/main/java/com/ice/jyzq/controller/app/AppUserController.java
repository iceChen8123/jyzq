//package com.ice.jyzq.controller.app;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.alibaba.fastjson.JSON;
//import com.ice.jyzq.controller.util.HttpUtil;
//import com.ice.jyzq.service.app.AppUserService;
//import com.ice.jyzq.service.app.TokenService;
//
//@Controller
//@RequestMapping(value = "app/user")
//public class AppUserController extends AppBaseController {
//
//	Logger logger = LoggerFactory.getLogger(getClass());
//
//	@Autowired
//	private TokenService tokenService;
//
//	@Autowired
//	private AppUserService appUserService;
//
//	@RequestMapping(value = "create", method = RequestMethod.POST)
//	@ResponseBody
//	public String createAppUser(HttpServletRequest request, String userName) {
//		HeaderInfo headerInfo = HttpUtil.getHeaderInfo(request);
//		logger.info("createAppUser : {}  userName: {}", new Object[] { JSON.toJSONString(headerInfo), userName });
//		String token = appUserService.createUser(userName, headerInfo);
//		return JSON.toJSONString(Response.successResponse(token));
//	}
//
//	// @RequestMapping(value = "authcode/get", method = RequestMethod.POST)
//	// @ResponseBody
//	// public String getAuthenticateCode(@RequestParam("token") String token,
//	// @RequestParam("mobile") String mobile,
//	// @RequestParam("uuid") String uuid) {
//	// return null;
//	// }
//	//
//	// @RequestMapping(value = "authenticate", method = RequestMethod.POST)
//	// @ResponseBody
//	// public String authenticate(@RequestParam("mobile") String mobile,
//	// @RequestParam("uuid") String uuid,
//	// @RequestParam("authcode") String authcode) {
//	// return null;
//	// }
//}
