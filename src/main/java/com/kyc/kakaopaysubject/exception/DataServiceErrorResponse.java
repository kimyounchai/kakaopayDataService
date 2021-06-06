package com.kyc.kakaopaysubject.exception;

public class DataServiceErrorResponse {

	
	private boolean success;
	
	private String errorMessage;

	public DataServiceErrorResponse(boolean success, String errorMessage) {
		super();
		this.success = success;
		this.errorMessage = errorMessage;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	
}
