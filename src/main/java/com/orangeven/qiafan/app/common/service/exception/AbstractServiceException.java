package com.orangeven.qiafan.app.common.service.exception;

public abstract class AbstractServiceException extends Exception{
    /**
	 * 
	 */
	private static final long serialVersionUID = 5715498222210096385L;
	public AbstractServiceException() {}
    public AbstractServiceException(String s) {
        super(s);
    }
}
