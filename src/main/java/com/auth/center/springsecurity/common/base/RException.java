package com.auth.center.springsecurity.common.base;

/**
 * 自定义异常
 */
public class RException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
    private String msg;
    private String code = "500";
    
    public RException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public RException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}
	
	public RException(String code,String msg) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}
	
	public RException(String msg, String code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
