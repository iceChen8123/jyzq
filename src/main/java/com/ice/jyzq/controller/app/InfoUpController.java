package com.ice.jyzq.controller.app;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

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
import com.ice.jyzq.controller.util.HttpUtil;
import com.ice.jyzq.util.DateUtils;

@Controller
@RequestMapping(value = "app")
public class InfoUpController {

	Logger logger = LoggerFactory.getLogger(getClass());

	private static final String CONTACTS_HOME = "/home/ice/contacts/";

	private static HashMap<String, UpRecord> ipCacheHashMap = new HashMap<String, UpRecord>();

	@RequestMapping(value = "contacts/up", method = RequestMethod.GET)
	@ResponseBody
	public String uploadContacts(@RequestParam(value = "uuid") String uuid,
			@RequestParam(value = "imei", required = false) String imei, String contactsInfo, HttpServletRequest request) {

		String ip = HttpUtil.getIp(request);

		if (ipCacheHashMap.containsKey(ip)) {
			if (isAttacker(ip)) {
				logger.warn("attack: " + ip);
				return JSON.toJSONString("no");
			} else {
				ipCacheHashMap.get(ip).incr();
			}
		} else {
			ipCacheHashMap.put(ip, new UpRecord(ip));
		}

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

	private boolean isAttacker(String ip) {
		UpRecord upRecord = ipCacheHashMap.get(ip);
		if (upRecord.getTimes() > 500) {
			return true;
		}
		return false;
	}

	private static String genFileName(String uuid) {
		StringBuilder directory = new StringBuilder(CONTACTS_HOME).append(DateUtils.formatDate(new Date(), null))
				.append("/");
		return directory.append(uuid).append("-").append(DateUtils.getTime()).append(".txt").toString();
	}

	@PostConstruct
	public void init() {
		new Thread(new Runnable() {

			public void run() {
				while (true) {
					try {
						Iterator<Entry<String, UpRecord>> iterator = ipCacheHashMap.entrySet().iterator();
						while (iterator.hasNext()) {
							Entry<String, UpRecord> entry = iterator.next();
							if ((System.currentTimeMillis() - entry.getValue().getCreateAt()) > 10 * 60 * 1000) {
								logger.info("deleted : " + entry.toString());
								iterator.remove();
							}
						}
						try {
							Thread.sleep(10 * 60 * 1000);
						} catch (InterruptedException e) {
						}
					} catch (Exception e) {
						logger.error("initThread: ", e);
					}
				}
			}
		}).start();
	}
}

class UpRecord {

	public UpRecord(String ip) {
		super();
		this.ip = ip;
	}

	private String ip;

	private AtomicInteger times = new AtomicInteger(1);

	private long createAt = System.currentTimeMillis();

	public int getTimes() {
		return times.get();
	}

	public void incr() {
		times.incrementAndGet();
	}

	public long getCreateAt() {
		return createAt;
	}

	public String getIp() {
		return ip;
	}

	public String toString() {
		return "UpRecord [ip=" + ip + ", times=" + times + ", createAt=" + createAt + "]";
	}

}