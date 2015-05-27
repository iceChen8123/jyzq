package com.ice.jyzq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping(value = { "/hello", "" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String home(Model model) {
		return "home";
	}
}
