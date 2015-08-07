package com.ice.jyzq.controller.app;

import com.ice.jyzq.constant.FailResponse;

public class Response {

	private int code;
	private String reason;
	private Object data;

	private Response() {
		super();
	}

	public static Response failResponse(FailResponse failResponse) {
		return new Response().setCode(failResponse.getCode()).setReason(failResponse.getDesc());
	}

	public static Response successResponse(Object data) {
		return new Response().setData(data);
	}

	public int getCode() {
		return code;
	}

	public Response setCode(int code) {
		this.code = code;
		return this;
	}

	public String getReason() {
		return reason;
	}

	public Response setReason(String reason) {
		this.reason = reason;
		return this;
	}

	public Object getData() {
		return data;
	}

	public Response setData(Object data) {
		this.data = data;
		return this;
	}

}
