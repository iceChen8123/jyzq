package com.ice.qiong.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Controller
public class LoginController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = { "/login" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String login(HttpServletRequest request, Model model,
			@RequestParam(value = "code", required = false) String code) {
		logger.info("loginFromDuoshuo: {}", code);
		try {
			String dsId = getDsIdByDsCode(code);
		} catch (Exception e) {
			logger.warn("login: ", e);
		}
		return "toindex";
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

			try {
				HttpGet httpGet = new HttpGet("http://api.duoshuo.com/users/profile.json?user_id=" + dsId);
				HttpResponse responset = httpclient.execute(httpGet);
				JSONObject userinforesponse = JSON.parseObject(EntityUtils.toString(responset.getEntity()));
				userinforesponse = (JSONObject) userinforesponse.get("response");
				logger.info("dsid:{}; dsInfo: {}", dsId, userinforesponse.toJSONString());
			} catch (ClientProtocolException e) {
				logger.error(" getDsIdByDsCode ClientProtocolException: ", e);
			} catch (IOException e) {
				logger.error(" getDsIdByDsCode IOException: ", e);
			}
		} catch (Exception e) {
			logger.warn("loginFromDuoshuo: ", e);
		}
		return dsId;
	}

	@RequestMapping(value = { "/logout" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpServletRequest request, @RequestParam(value = "code", required = false) String code) {
		logger.info("logoutFromDuoshuo: {}", code);
		return "toindex";
	}

}
