package com.orangeven.qiafan.app.common.model.http;

public class ErrorResponse {
	private String errorMessage;
	private String errorCode;
	
	public ErrorResponse(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMessage = errorMsg;
	}
	
	public ErrorResponse(String errorMsg) {
		this.errorMessage = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
