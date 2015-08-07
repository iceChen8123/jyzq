package com.ice.jyzq.constant;

public enum FailResponse {

	WrongToken(10001, "错误token");

	FailResponse(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	private int code;

	private String desc;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}