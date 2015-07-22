package com.ice.jyzq.controller.app;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ice.jyzq.controller.util.HttpUtil;

@Controller
@RequestMapping(value = "appuser/")
public class AppUserController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "create", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String create(@RequestParam("mobile") String mobile, @RequestParam("uuid") String uuid,
			@RequestParam(value = "imei", required = false) String imei, HttpServletRequest request) {
		String ip = HttpUtil.getIp(request);

		return JSON.toJSONString("token");
	}

	@RequestMapping(value = "authcode/get", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String getAuthenticateCode(@RequestParam("token") String token, @RequestParam("mobile") String mobile,
			@RequestParam("uuid") String uuid) {
		return null;
	}

	@RequestMapping(value = "authenticate", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String authenticate(@RequestParam("mobile") String mobile, @RequestParam("uuid") String uuid,
			@RequestParam("authcode") String authcode) {
		return null;
	}
}
