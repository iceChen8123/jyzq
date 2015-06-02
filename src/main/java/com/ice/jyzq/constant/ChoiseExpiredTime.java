package com.ice.jyzq.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ice.jyzq.util.JsonMapper;

public enum ChoiseExpiredTime {

	ONE_HOUR(60 * 60 * 1000L, "1小时"), ONE_DAY(24 * 60 * 60 * 1000L, "1天"), ONE_WEEK(7 * 24 * 60 * 60 * 1000L, "1周"), ONE_MONTH(
			30 * 24 * 60 * 60 * 1000L, "1月"), FOREVER(Long.MAX_VALUE, "永远"), ;

	private long expiredTime;
	private String desc;

	private ChoiseExpiredTime(long expiredTime, String desc) {
		this.expiredTime = expiredTime;
		this.desc = desc;
	}

	public long getExpiredTime() {
		return expiredTime;
	}

	public void setExpiredTime(long expiredTime) {
		this.expiredTime = expiredTime;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static ChoiseExpiredTime getByExpiredTime(long expiredTime) {
		for (ChoiseExpiredTime choiseExpiredTime : ChoiseExpiredTime.values()) {
			if (expiredTime == choiseExpiredTime.getExpiredTime()) {
				return choiseExpiredTime;
			}
		}
		return FOREVER;
	}

	public static void main(String[] args) {
		System.out.println(getByExpiredTime(7 * 24 * 60 * 60 * 1000).getDesc());
	}

	public static List<Map<String, Object>> getList() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (ChoiseExpiredTime choiseExpiredTime : ChoiseExpiredTime.values()) {
			Map<String, Object> e = new HashMap<String, Object>();
			e.put("expiredTime", choiseExpiredTime.getExpiredTime());
			e.put("desc", choiseExpiredTime.getDesc());
			list.add(e);
		}
		return list;
	}
}
