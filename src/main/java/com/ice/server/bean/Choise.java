package com.ice.server.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_choise")
public class Choise implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "create_time")
	private Date createTime;
	@Column(name = "update_time")
	private Date updateTime;

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

	@Column(name = "user_name")
	private String userName;
	@Column(name = "city_id")
	private Integer cityId;
	@Column(name = "address_id")
	private Integer addressId;
	@Column(name = "title")
	private String title;
	@Column(name = "choise_code")
	private String choiseCode;
	@Column(name = "subject_id")
	private Long subjectId;
	@Column(name = "choises")
	private String choises;
	@Column(name = "votes")
	private String votes;
	@Column(name = "choise_desc")
	private String choiseDesc;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getChoiseCode() {
		return choiseCode;
	}

	public void setChoiseCode(String choiseCode) {
		this.choiseCode = choiseCode;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getChoises() {
		return choises;
	}

	public void setChoises(String choises) {
		this.choises = choises;
	}

	public String getVotes() {
		return votes;
	}

	public void setVotes(String votes) {
		this.votes = votes;
	}

	public String getChoiseDesc() {
		return choiseDesc;
	}

	public void setChoiseDesc(String choiseDesc) {
		this.choiseDesc = choiseDesc;
	}

}
