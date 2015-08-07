package com.ice.jyzq.controller.util;

import javax.servlet.http.HttpServletRequest;

import com.ice.jyzq.controller.app.HeaderInfo;

public class HttpUtil {

	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public static HeaderInfo getHeaderInfo(HttpServletRequest request) {
		HeaderInfo headerInfo = new HeaderInfo();
		headerInfo.setImei(request.getHeader("imei"));
		headerInfo.setModel(request.getHeader("model"));
		headerInfo.setUuid(request.getHeader("uuid"));
		headerInfo.setVendor(request.getHeader("vendor"));
		return headerInfo;
	}

}
