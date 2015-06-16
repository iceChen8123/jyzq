package com.ice.jyzq.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ice.jyzq.common.UserUtil;
import com.ice.jyzq.controller.base.BaseController;
import com.ice.jyzq.service.UserService;
import com.ice.jyzq.util.JsonMapper;
import com.ice.server.bean.User;

/**
 * 登录Controller
 */
@Controller
public class LoginController extends BaseController {

	@Autowired
	private UserUtil userUtil;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "loginfromds", method = { RequestMethod.GET, RequestMethod.POST })
	public String loginFromDuoshuo(HttpServletRequest request, Model model,
			@RequestParam(value = "code", required = false) String code) {
		logger.info("loginFromDuoshuo: {}", code);
		String dsId = getDsIdByDsCode(code);
		if (StringUtils.isBlank(dsId)) {
			model.addAttribute("message", "陛下您没登上来了!_!要不直接通过本站登录吧.");
			model.addAttribute("user", new User());
			return "loginj";
		}

		User user = userService.findByDsId(dsId);
		if (user != null && StringUtils.isNotBlank(user.getUserName())) {
			logger.info("用户 {} 通过ds 登录了...", user.getUserName());
			SecurityUtils.getSubject().login(
					new UsernamePasswordToken(user.getUserName(), "81231707", true, request.getRemoteHost())); // special
																												// keycode
			model.addAttribute("message", "陛下您登上来了~有什么纠结的,请告诉众卿家吧 #_#");
			return "home";
		} else {
			logger.info("用户 dsid {} 通过ds 跳转到注册页面...", dsId);
			model.addAttribute("message", "请陛下在本站登记下.避免您将来不能通过其他账户登录,谢谢.");
			model.addAttribute("dsid", dsId);
			model.addAttribute("user", new User());
			return "register";
		}
	}

	private String getDsIdByDsCode(String code) {
		String dsId = "";

		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httpost = new HttpPost("http://api.duoshuo.com/oauth2/access_token");
		httpost.setHeader("Content-Type", "application/x-www-form-urlencoded");

		List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
		nvps.add(new BasicNameValuePair("code", code));
		nvps.add(new BasicNameValuePair("client_id", "jyzq"));
		try {
			httpost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			logger.warn("loginFromDuoshuo: ", e1);
		}
		try {
			// {"access_token":"d1decdc8d6e2492a69e0f0c6033f0e24","expires_in":7776000,"user_id":"12247047","remind_in":7770149,"code":0}
			HttpResponse httpResponse = httpclient.execute(httpost);
			String response = EntityUtils.toString(httpResponse.getEntity());
			JSONObject jsonObject = JSON.parseObject(response);
			if (jsonObject.get("code") != null && "990002".equals(jsonObject.get("code"))) {
				logger.warn("loginFromDuoshuo: " + jsonObject);
			} else {
				if (jsonObject.get("user_id") != null) {
					dsId = jsonObject.get("user_id").toString();
				}
			}

			// HttpGet httpGet = new
			// HttpGet("http://api.duoshuo.com/users/profile.json?user_id=" +
			// userId);
			// try {
			// HttpResponse responset = httpclient.execute(httpGet);
			//
			// JSONObject userinforesponse =
			// JSON.parseObject(EntityUtils.toString(responset.getEntity()));
			// userinforesponse = (JSONObject) userinforesponse.get("response");
			// // System.out.println(jsonObject.get("user_id"));
			// // System.out.println(jsonObject.get("name"));
			// // System.out.println(jsonObject.get("url"));
			// // jsonObject = (JSONObject)
			// // jsonObject.get("connected_services");
			// // System.out.println(jsonObject.toJSONString());
			// } catch (ClientProtocolException e) {
			// e.printStackTrace();
			// } catch (IOException e) {
			// e.printStackTrace();
			// }

		} catch (Exception e) {
			logger.warn("loginFromDuoshuo: ", e);
		}
		return dsId;
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
		// SecurityUtils.getSubject().logout();
		// User user = userUtil.getUser();
		// 如果已经登录，则跳转到管理首页
		if (StringUtils.isNotBlank(userUtil.getCurrentUserName())) {
			return "forward:hello";
		}
		if (StringUtils.isNotBlank(request.getParameter("message"))) {
			if ("pleaseloginfirst".equals(request.getParameter("message"))) {
				model.addAttribute("message", "你登录了,才能丢问题给大家oO $_$");
			}
		}
		model.addAttribute("user", new User());
		return "loginj";
	}

	@RequestMapping(value = "tologout", method = RequestMethod.GET)
	public String tologout(Model model) {
		return "forward:logout";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(Model model) {
		SecurityUtils.getSubject().logout();
		model.addAttribute("message", "已安全退出");
		return "forward:hello";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(User user, @RequestParam(value = "rememberMe", defaultValue = "false") Boolean rememberMe,
			HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
		if (StringUtils.isBlank(user.getUserName())) {
			model.addAttribute("message", "用户名不能为空");
			return "loginj";
		}
		if (StringUtils.isBlank(user.getPassword())) {
			model.addAttribute("message", "密码不能为空");
			return "loginj";
		}
		User usertemp = userUtil.getUser();
		if (usertemp != null && usertemp.getId() != null) {
			return "forward:hello";
		} else {
			try {
				// 成功后，会自动跳转到 successUrl，与return无关
				SecurityUtils.getSubject().login(
						new UsernamePasswordToken(user.getUserName(), user.getPassword(), rememberMe, request
								.getRemoteHost()));
				// model.addAttribute("message", "欢迎光临");
			} catch (AuthenticationException e) {
				model.addAttribute("message", "用户名或密码错误");
				logger.warn(user.getUserName() + " 登录失败.", e);
				return "loginj";
			}
		}
		model.addAttribute("message", "陛下您登上来了~有什么纠结的,请告诉众卿家吧 #_#");
		return "forward:hello";
	}

	@RequestMapping(value = "checkiflogin", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String checkiflogin() {
		User user = userUtil.getUser();
		// 如果已经登录，则跳转到管理首页
		if (user != null && user.getId() != null) {
			return JsonMapper.toJsonString("true");
		}
		return JsonMapper.toJsonString("false");
	}

	public static void main(String[] args) throws UnsupportedEncodingException { // 1f7a6a18563b6ad221dff75c900bc436
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httpost = new HttpPost("http://api.duoshuo.com/oauth2/access_token");
		httpost.setHeader("Content-Type", "application/x-www-form-urlencoded");

		List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
		nvps.add(new BasicNameValuePair("code", "c055eed5a986ffaa5ac09d112baed0c4"));
		nvps.add(new BasicNameValuePair("client_id", "jyzq"));
		httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
		String userId = "";
		try {
			HttpResponse httpResponse = httpclient.execute(httpost);
			String response = EntityUtils.toString(httpResponse.getEntity());
			System.out.println(response);
			JSONObject jsonObject = JSON.parseObject(response);
			System.out.println(jsonObject.get("user_id"));
			userId = jsonObject.get("user_id").toString();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		HttpGet httpGet = new HttpGet("http://api.duoshuo.com/users/profile.json?user_id=" + userId);
		try {
			HttpResponse httpResponse = httpclient.execute(httpGet);
			String response = EntityUtils.toString(httpResponse.getEntity());
			System.out.println(response);

			JSONObject jsonObject = JSON.parseObject(response);
			jsonObject = (JSONObject) jsonObject.get("response");
			System.out.println(jsonObject.get("user_id"));
			System.out.println(jsonObject.get("name"));
			System.out.println(jsonObject.get("url"));
			jsonObject = (JSONObject) jsonObject.get("connected_services");
			System.out.println(jsonObject.toJSONString());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
