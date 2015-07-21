package com.ice.jyzq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ice.jyzq.common.UserUtil;

@Controller
public class HomeController {

	@Autowired
	private UserUtil userUtil;

	@RequestMapping(value = { "/hello", "", "/b/hello" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String home(Model model) {
		return "home";
	}

}
