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
@Table(name = "tb_choise_item")
public class ChoiseItem implements Serializable {

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
	@Column(name = "subject_id")
	private Long subjectId;
	@Column(name = "choise_name")
	private String choiseName;
	@Column(name = "choise_cn_name")
	private String choiseCnName;
	@Column(name = "create_num")
	private Long createNum;
	@Column(name = "vote_num")
	private Long voteNum;

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

	public String getChoiseName() {
		return choiseName;
	}

	public void setChoiseName(String choiseName) {
		this.choiseName = choiseName;
	}

	public String getChoiseCnName() {
		return choiseCnName;
	}

	public void setChoiseCnName(String choiseCnName) {
		this.choiseCnName = choiseCnName;
	}

	public Long getCreateNum() {
		return createNum;
	}

	public void setCreateNum(Long createNum) {
		this.createNum = createNum;
	}

	public Long getVoteNum() {
		return voteNum;
	}

	public void setVoteNum(Long voteNum) {
		this.voteNum = voteNum;
	}

}
