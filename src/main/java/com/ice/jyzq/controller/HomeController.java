package com.ice.jyzq.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ice.jyzq.common.UserUtil;
import com.ice.jyzq.util.JsonMapper;

@Controller
public class HomeController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserUtil userUtil;

	@RequestMapping(value = { "/hello", "", "/b/hello" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String home(Model model) {
		return "home";
	}
	
	@RequestMapping(value = { "/ip" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String getIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		logger.info("getIp: {} ", ip);
		return JsonMapper.toJsonString(ip);
	}

}
