package com.ice.auth;

import java.io.IOException;
import java.util.Random;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

public class AuthFilter implements Filter {

	private static final Random RANDOM = new Random();
	private static final String COOKIE_ID_FIELD = "id";
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		HttpServletRequest request1 = (HttpServletRequest) request;
		HttpServletResponse response1 = (HttpServletResponse) response;

		String ip = getIp(request);
		UserInfo.setIp(ip);

		logger.info("ip:{}", new Object[] { ip });
		boolean isFirstLog = true;
		for (Cookie cookie : request1.getCookies()) {
			if (COOKIE_ID_FIELD.equals(cookie.getName())) {
				isFirstLog = false;
				logger.debug("cookie:{}", JSON.toJSONString(cookie));
				String cookieId = cookie.getValue();
				if (!LogonCache.hasLogInfo(cookieId)) {
					cookieId = genCookieId();
					Cookie cookietmp = new Cookie(COOKIE_ID_FIELD, cookieId);
					response1.addCookie(cookietmp);
				}
				LogonCache.recordLoginId(cookieId);
			}
		}
		if (isFirstLog) {
			String cookieId = genCookieId();
			Cookie cookietmp = new Cookie(COOKIE_ID_FIELD, cookieId);
			response1.addCookie(cookietmp);
			LogonCache.recordLoginId(cookieId);
		}
		chain.doFilter(request, response);
	}

	private String genCookieId() {
		return UserInfo.getIp() + "-" + System.currentTimeMillis() + "-" + RANDOM.nextInt(1000);
	}

	private String getIp(ServletRequest request) {
		HttpServletRequest requestt = (HttpServletRequest) request;
		String ip = requestt.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = requestt.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = requestt.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	@Override
	public void destroy() {
		LogonCache.shutdown();
	}
}
