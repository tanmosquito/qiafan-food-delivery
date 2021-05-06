package com.orangeven.qiafan.app.common.service.exception;

public class ResourceSetSizeTooLargeException extends AbstractServiceException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7616120351379688239L;
	public ResourceSetSizeTooLargeException() {
        super("Resource set too large.");
    };
    public ResourceSetSizeTooLargeException(String msg) {
        super(msg);
    }
}
