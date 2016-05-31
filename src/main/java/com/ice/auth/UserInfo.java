package com.ice.auth;

public class UserInfo {

	static ThreadLocal<String> ip = new ThreadLocal<String>();

	public static String getIp() {
		return ip.get();
	}

	static void setIp(String ip) {
		UserInfo.ip.set(ip);
	}

}
