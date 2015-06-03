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
	private Integer cityId;
	private String city;
	private Long addressId;
	private String address;
	private String userName;
	private String title;
	private Long subjectId;
	private String subject;
	private String choiseCode;
	private List<Map<String, Object>> choiseAndVote = new ArrayList<Map<String, Object>>();
	private String choiseDesc;

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

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

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getChoiseCode() {
		return choiseCode;
	}

	public void setChoiseCode(String choiseCode) {
		this.choiseCode = choiseCode;
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
