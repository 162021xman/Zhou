package com.example.demo.Bean.vo;

public class T {
private boolean success;
	
	private String msg;
	
	private T(boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}
	
	public static T ok() {
		return new T(true, "");
	}
	
	public static T fail(String msg) {
		return new T(false, msg);
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
