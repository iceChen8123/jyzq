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
	@Column(name = "title")
	private String title;
	@Column(name = "choise_type")
	private String choiseType;
	@Column(name = "choises")
	private String choises;
	@Column(name = "votes")
	private String votes;
	@Column(name = "choise_desc")
	private String choiseDesc;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getChoiseDesc() {
		return choiseDesc;
	}

	public void setChoiseDesc(String choiseDesc) {
		this.choiseDesc = choiseDesc;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getChoiseType() {
		return choiseType;
	}

	public void setChoiseType(String choiseType) {
		this.choiseType = choiseType;
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

}
