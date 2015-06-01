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
@Table(name = "sys_choise_type")
public class ChoiseType implements Serializable {

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
	@Column(name = "choise_name")
	private String choiseName;
	@Column(name = "valid")
	private Integer valid;

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

	public String getChoiseName() {
		return choiseName;
	}

	public void setChoiseName(String choiseName) {
		this.choiseName = choiseName;
	}

	public boolean isOk() {
		return getValid() == 1;
	}

}
