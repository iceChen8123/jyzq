package com.ice.jyzq.constant;

public enum FailResponse {

	WrongToken(10001, "错误token"), NotExistToken(10002, "不存在的token"), QiongTooLong(200001, "太长了~~受不了了~~~~");

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
