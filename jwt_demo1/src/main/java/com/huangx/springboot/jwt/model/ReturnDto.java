package com.huangx.springboot.jwt.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/18.
 */
public class ReturnDto<T> implements Serializable {
	private String status; // 0 - 成功
	private String errorMsg;
	private String errorCode;
	private T data;

	private static final String ERROR = "-1";
	private static final String SUCCESS = "0";

	public ReturnDto() {
		this.status = ERROR;
		this.errorCode = "000000";
		this.errorMsg = "";
	}

	public ReturnDto(T data) {
		this.status = SUCCESS;
		this.data = data;
	}

	public ReturnDto(String errorCode, String errorMsg) {
		setError(errorCode, errorMsg);
	}

	public void setError(String errorCode, String errorMsg) {
		this.status = ERROR;
		if ( null != errorCode && errorCode.trim().length() > 0 ) {
			this.errorCode = errorCode;
		}
		this.errorMsg = errorMsg;
	}

	public void setSuccess() {
		this.status = SUCCESS;
	}

	public void setSuccess(T data) {
		setSuccess();
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}


	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
