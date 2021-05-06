package com.orangeven.qiafan.app.common.service.exception;

public class AuthenFailedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1488202186421570572L;
	public AuthenFailedException() {}
	public AuthenFailedException(String msg) {
		super(msg);
	}
}
