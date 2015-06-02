package com.ice.jyzq.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum VoteArea {

	ARROUND("arround", "附近"), SAME_CITY("city", "同城"), SAME_PROVINCE("province", "同省市"), NATIONWIDE("nationwide", "全国");

	private String voteArea;
	private String desc;

	private VoteArea(String voteArea, String desc) {
		this.voteArea = voteArea;
		this.desc = desc;
	}

	public String getVoteArea() {
		return voteArea;
	}

	public void setVoteArea(String voteArea) {
		this.voteArea = voteArea;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static List<Map<String, Object>> getList() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (VoteArea voteArea : VoteArea.values()) {
			Map<String, Object> e = new HashMap<String, Object>();
			e.put("voteArea", voteArea.getVoteArea());
			e.put("desc", voteArea.getDesc());
			list.add(e);
		}
		return list;
	}
}
