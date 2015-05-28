package com.ice.jyzq.controller.back;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ice.jyzq.controller.base.BaseController;
import com.ice.server.bean.User;

/**
 * 登录Controller
 */
@Controller
public class LoginController extends BaseController {

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("message", "请登录");
		return "login";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(Model model) {
		SecurityUtils.getSubject().logout();
		model.addAttribute("message", "已安全退出");
		return "forward:hello";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(User user, HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			// 成功后，会自动跳转到 successUrl，与return无关
			SecurityUtils.getSubject().login(new UsernamePasswordToken(user.getUserName(), user.getPassword()));
			model.addAttribute("message", "欢迎光临");
		} catch (AuthenticationException e) {
			model.addAttribute("message", "请先登录");
			logger.warn("{} 登录失败.", user.getUserName());
		}
		return "forward:hello";
	}

}
