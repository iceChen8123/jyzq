package com.ice.jyzq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

	@RequestMapping(value = { "/hello", "", "/b/hello" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String home(Model model,RedirectAttributes redirectAttributes) {
		return "home";
	}
}
