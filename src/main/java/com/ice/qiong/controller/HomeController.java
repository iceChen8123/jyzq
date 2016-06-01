package com.ice.qiong.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ice.auth.UserInfo;
import com.ice.jyzq.util.JsonMapper;

@Controller
public class HomeController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = { "/hello" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String home(HttpServletRequest request, HttpServletResponse response) {
		return "home";
	}

	@RequestMapping(value = { "/ip" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String getIp(HttpServletRequest request) {
		return JsonMapper.toJsonString(UserInfo.getIp());
	}

}
