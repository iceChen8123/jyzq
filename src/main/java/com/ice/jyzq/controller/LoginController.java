package com.ice.jyzq.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ice.jyzq.common.UserUtil;
import com.ice.jyzq.controller.base.BaseController;
import com.ice.server.bean.User;

/**
 * 登录Controller
 */
@Controller
public class LoginController extends BaseController {

	@Autowired
	private UserUtil userUtil;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		logger.info("来了。。。get....login........");
		SecurityUtils.getSubject().logout();
		User user = userUtil.getUser();
		// 如果已经登录，则跳转到管理首页
		if (user != null && user.getId() != null) {
			return "forward:hello";
		}
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(Model model) {
		SecurityUtils.getSubject().logout();
		model.addAttribute("message", "已安全退出");
		return "forward:hello";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(User user, @RequestParam(value = "rememberMe", defaultValue = "false") Boolean rememberMe,
			HttpServletRequest request,HttpServletResponse response, Model model) {
		User usertemp = userUtil.getUser();
		if (usertemp != null && usertemp.getId() != null) {
			return "forward:hello";
		} else {
			try {
				// 成功后，会自动跳转到 successUrl，与return无关
				SecurityUtils.getSubject().login(
						new UsernamePasswordToken(user.getUserName(), user.getPassword(), rememberMe,request.getRemoteHost()));
				model.addAttribute("message", "欢迎光临");
			} catch (AuthenticationException e) {
				model.addAttribute("message", "用户名或密码错误");
				logger.warn(user.getUserName()+" 登录失败.",e);
				return "login";
			}
		}
		return "forward:hello";
	}
}
