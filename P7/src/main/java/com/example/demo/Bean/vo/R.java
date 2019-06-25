package com.example.demo.Bean.vo;

public class R {
	private boolean success;
	
	private String msg;
	
	private R(boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}
	
	public static R ok() {
		return new R(true, "");
	}
	
	public static R fail(String msg) {
		return new R(false, msg);
	}
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
