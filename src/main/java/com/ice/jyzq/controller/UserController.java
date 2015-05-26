package com.ice.jyzq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ice.jyzq.service.UserService;
import com.ice.server.bean.User;

@Controller
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(Model model, User user) {
		if (userService.ifUserExists(user.getUserName())) {
			model.addAttribute("message", "用户名重复");
			model.addAttribute("user", user);
			return "register";
		}
		userService.save(user.getUserName(), user.getPassword());
		model.addAttribute("message", "注册成功，请登录");
		return "forward:hello";
	}

}
