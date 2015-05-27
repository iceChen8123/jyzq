package com.ice.jyzq.controller.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChoiseVo {

	private Long id;
	private Date createTime;
	private Date updateTime;
	private String userName;
	private String title;
	private String choiseType;
	private List<Map<String, Object>> choiseAndVote = new ArrayList<Map<String, Object>>();
	private String choiseDesc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getChoiseType() {
		return choiseType;
	}

	public void setChoiseType(String choiseType) {
		this.choiseType = choiseType;
	}

	public List<Map<String, Object>> getChoiseAndVote() {
		return choiseAndVote;
	}

	public void addChoiseAndVote(String choise, String vote) {
		Map<String, Object> cMap = new HashMap<String, Object>();
		cMap.put("choise", choise);
		cMap.put("vote", vote);
		choiseAndVote.add(cMap);
	}

	public String getChoiseDesc() {
		return choiseDesc;
	}

	public void setChoiseDesc(String choiseDesc) {
		this.choiseDesc = choiseDesc;
	}
}
