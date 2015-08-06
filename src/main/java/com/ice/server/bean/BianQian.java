package com.ice.server.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_app_bianqian")
public class BianQian {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "bq_status")
	private Integer bqStatus;
	@Column(name = "title")
	private String title;
	@Column(name = "content")
	private String content;
	@Column(name = "create_time")
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getBqStatus() {
		return bqStatus;
	}

	public void setBqStatus(Integer bqStatus) {
		this.bqStatus = bqStatus;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String toString() {
		return "BianQian [id=" + id + ", userName=" + userName + ", bqStatus=" + bqStatus + ", title=" + title
				+ ", content=" + content + ", createTime=" + createTime + "]";
	}

}
