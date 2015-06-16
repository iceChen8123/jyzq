package com.ice.server.bean.sys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_subject")
public class ChoiseSubject implements Serializable {

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

	@Column(name = "choise_code")
	private String choiseCode;
	@Column(name = "subject_name")
	private String subjectName;
	@Column(name = "expired_time")
	private Long expiredTime;
	@Column(name = "vote_area")
	private String voteArea;
	@Column(name = "has_comment")
	private Integer hasComment;
	@Column(name = "valid")
	private Integer valid;

	public Integer getHasComment() {
		return hasComment;
	}

	public void setHasComment(Integer hasComment) {
		this.hasComment = hasComment;
	}

	public Integer getValid() {
		return valid;
	}

	public void setValid(Integer valid) {
		this.valid = valid;
	}

	public String getChoiseCode() {
		return choiseCode;
	}

	public void setChoiseCode(String choiseCode) {
		this.choiseCode = choiseCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Long getExpiredTime() {
		return expiredTime;
	}

	public void setExpiredTime(Long expiredTime) {
		this.expiredTime = expiredTime;
	}

	public String getVoteArea() {
		return voteArea;
	}

	public void setVoteArea(String voteArea) {
		this.voteArea = voteArea;
	}

}
