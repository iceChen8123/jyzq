package com.ice.auth;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

public class LogonCache {

	private static Set<String> logonIds = new HashSet<String>();
	private static Map<String, AtomicInteger> loginTimeCache = new HashMap<String, AtomicInteger>();
	static Logger logger = LoggerFactory.getLogger(LogonCache.class);

	static boolean hasLogInfo(String id) {
		return logonIds.contains(id);
	}

	static void recordLoginId(String id) {
		logonIds.add(id);
		if (loginTimeCache.containsKey(id)) {
			loginTimeCache.get(id).incrementAndGet();
		} else {
			loginTimeCache.put(id, new AtomicInteger(0));
		}
	}

	static void shutdown() {
		logger.info("登陆过的人:{}", JSON.toJSONString(loginTimeCache));
	}

}
