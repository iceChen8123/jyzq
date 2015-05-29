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
@Table(name = "tb_user_vote")
public class UserVote implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "create_time")
	private Date createTime;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "choise_id")
	private Long choiseId;
	@Column(name = "vote_choise")
	private String voteChoise;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getChoiseId() {
		return choiseId;
	}

	public void setChoiseId(Long choiseId) {
		this.choiseId = choiseId;
	}

	public String getVoteChoise() {
		return voteChoise;
	}

	public void setVoteChoise(String voteChoise) {
		this.voteChoise = voteChoise;
	}

}
