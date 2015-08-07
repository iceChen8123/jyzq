package com.ice.jyzq.controller.app;

import java.util.UUID;

import org.apache.commons.codec.digest.Md5Crypt;

import com.alibaba.fastjson.JSON;

public class TokenUtil {

	public static String genToken(HeaderInfo headerInfo) {
		return Md5Crypt.apr1Crypt(JSON.toJSONString(headerInfo).getBytes(),
				headerInfo.getVendor() + headerInfo.getImei());
	}

	public static String genToken1(HeaderInfo headerInfo) {
		return Md5Crypt.apr1Crypt(JSON.toJSONString(headerInfo).getBytes());
	}

	public static void main(String[] args) {
		HeaderInfo headerInfo = new HeaderInfo();
		headerInfo.setImei("imei");
		headerInfo.setModel("model");
		headerInfo.setUuid(UUID.randomUUID().toString());
		headerInfo.setVendor("vendor");
		System.out.println(genToken(headerInfo));
		System.out.println(genToken1(headerInfo));
	}
}
