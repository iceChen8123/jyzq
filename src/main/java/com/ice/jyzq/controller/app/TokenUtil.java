package com.ice.jyzq.controller.app;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.Md5Crypt;

import com.alibaba.fastjson.JSON;
import com.ice.jyzq.controller.util.HttpUtil;
import com.ice.server.bean.app.AppUserToken;

public class TokenUtil {

	public static String genToken(HeaderInfo headerInfo) {
		return System.currentTimeMillis()
				+ Md5Crypt.apr1Crypt(JSON.toJSONString(headerInfo).getBytes(),
						headerInfo.getVendor() + headerInfo.getImei());
	}

	public static String genToken(HttpServletRequest request) {
		HeaderInfo headerInfo = HttpUtil.getHeaderInfo(request);
		return System.currentTimeMillis()
				+ Md5Crypt.apr1Crypt(JSON.toJSONString(headerInfo).getBytes(),
						headerInfo.getVendor() + headerInfo.getImei());
	}

	public static boolean isRightToken(HttpServletRequest request, String token) {
		if (token.length() < 14) {
			return false;
		}
		return token.substring(13).equals(genToken(request).substring(13));
	}

	private static boolean isRightToken(HeaderInfo headerInfo, String token) {
		if (token.length() < 14) {
			return false;
		}
		return token.substring(13).equals(genToken(headerInfo).substring(13));
	}

	public static void main(String[] args) {
		HeaderInfo headerInfo = new HeaderInfo();
		headerInfo.setImei("imei");
		headerInfo.setModel("model");
		headerInfo.setUuid(UUID.randomUUID().toString());
		headerInfo.setVendor("vendor");
		String genToken = genToken(headerInfo);
		System.out.println(genToken);
		System.out.println(isRightToken(headerInfo, genToken));
		System.out.println(genToken.substring(0, 13));
		System.out.println(genToken.substring(13));
	}

	public static boolean isNeedNewToken(AppUserToken appUserToken) {
		try {
			Long createTime = Long.parseLong(appUserToken.getToken().substring(0, 13));
			return System.currentTimeMillis() - createTime > 24 * 60 * 60 * 1000;
		} catch (Exception e) {
		}
		return false;
	}
}
