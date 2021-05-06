package com.orangeven.qiafan.app.common.controller.exception;

public class IllegalRequestParameterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1162566852534604131L;
	public IllegalRequestParameterException() {
		super("illegal paramter.");
	}
	public IllegalRequestParameterException(String msg) {
		super(msg);
	}
}
