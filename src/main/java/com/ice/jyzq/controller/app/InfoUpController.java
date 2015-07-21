package com.ice.jyzq.controller.app;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ice.jyzq.util.DateUtils;

@Controller
@RequestMapping(value = "app")
public class InfoUpController {

	Logger logger = LoggerFactory.getLogger(getClass());

	private static final String CONTACTS_HOME = "/home/ice/contacts/";

	@RequestMapping(value = "contacts/up", method = RequestMethod.GET)
	@ResponseBody
	public String uploadContacts(@RequestParam(value = "uuid") String uuid,
			@RequestParam(value = "imei", required = false) String imei, String contactsInfo) {

		JSONObject recordInfo = new JSONObject();
		if (StringUtils.isNotBlank(imei)) {
			recordInfo.put("uuid", uuid);
		}
		recordInfo.put("uuid", uuid);
		recordInfo.put("contacts", contactsInfo);
		File recordFile = new File(genFileName(uuid));
		try {
			FileUtils.writeStringToFile(recordFile, contactsInfo, Charset.forName("UTF-8"));
		} catch (Exception e) {
			logger.error("uploadContacts: ", e);
			logger.error("uuid: " + uuid + "; saveContacts: " + contactsInfo);
		}
		return JSON.toJSONString("ok");
	}

	private static String genFileName(String uuid) {
		StringBuilder directory = new StringBuilder(CONTACTS_HOME).append(DateUtils.formatDate(new Date(), null))
				.append("/");
		return directory.append(uuid).append(".txt").toString();
	}
}
