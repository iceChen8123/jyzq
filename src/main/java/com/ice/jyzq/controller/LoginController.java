package com.ice.jyzq.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
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
		return "modules/sys/sysLogin";
	}

	/**
	 * 登录失败，真正登录的POST请求由Filter完成
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String username,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		// User user = UserUtils.getUser();
		// // 如果已经登录，则跳转到管理首页
		// if (user.getId() != null) {
		// return "redirect:" + Global.getAdminPath();
		// }
		model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, username);
		model.addAttribute("isValidateCodeLogin", isValidateCodeLogin(username, true, false));
		return "modules/sys/sysLogin";
	}

	/**
	 * 登录成功，进入管理首页
	 */
	@RequiresUser
	@RequestMapping(value = "${adminPath}")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		// User user = UserUtils.getUser();
		// // 未登录，则跳转到登录页
		// if (user.getId() == null) {
		// return "redirect:" + Global.getAdminPath() + "/login";
		// }
		// // 登录成功后，验证码计算器清零
		// isValidateCodeLogin(user.getLoginName(), false, true);
		// // 登录成功后，获取上次登录的当前站点ID
		// UserUtils.putCache("siteId", CookieUtils.getCookie(request,
		// "siteId"));
		return "modules/sys/sysIndex";
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

	@SuppressWarnings("resource")
	@RequestMapping("${adminPath}/download")
	public String download(@RequestParam String filePath, HttpServletResponse response) {
		File file = new File(filePath);
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(filePath);
			response.reset();
			response.setContentType("application/octet-stream;charset=UTF-8");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
			OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
			byte data[] = new byte[1024];
			while (inputStream.read(data, 0, 1024) >= 0) {
				outputStream.write(data);
			}
			outputStream.flush();
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
