package com.ice.jyzq.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 登录Controller
 */
@Controller
public class LoginController extends BaseController {

	@Autowired
	private UserUtils userUtils;

	static private Map<String, Integer> loginFailMap = new ConcurrentHashMap<String, Integer>();

	/**
	 * 管理登录
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
		// User user = UserUtils.getUser();
		// // 如果已经登录，则跳转到管理首页
		// if (user.getId() != null) {
		// return "redirect:" + Global.getAdminPath();
		// }
		logger.info("管理登录.");
		return "login";
	}

	/**
	 * 登录失败，真正登录的POST请求由Filter完成
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String username,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, username);
		model.addAttribute("isValidateCodeLogin", isValidateCodeLogin(username, true, false));
		logger.info("{} 登录失败.", username);
		return "/";
	}

	/**
	 * 登录成功，进入管理首页
	 */
	@RequiresUser
	@RequestMapping(value = "${adminPath}")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		logger.info("{} 登录失败.", userUtils.getUser().getUserName());
		return "hello";
	}

	/**
	 * 是否是验证码登录
	 * 
	 * @param useruame
	 *            用户名
	 * @param isFail
	 *            计数加1
	 * @param clean
	 *            计数清零
	 * @return
	 */
	public static boolean isValidateCodeLogin(String useruame, boolean isFail, boolean clean) {
		Integer loginFailNum = loginFailMap.get(useruame);
		if (loginFailNum == null) {
			loginFailNum = 0;
		}
		if (isFail) {
			loginFailNum++;
			loginFailMap.put(useruame, loginFailNum);
		}
		if (clean) {
			loginFailMap.remove(useruame);
		}
		return loginFailNum >= 3;
	}

}
