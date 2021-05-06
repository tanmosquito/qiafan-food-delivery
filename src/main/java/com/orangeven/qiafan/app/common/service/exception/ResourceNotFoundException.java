package com.orangeven.qiafan.app.common.service.exception;

public class ResourceNotFoundException extends AbstractServiceException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6356638808412641194L;
	public ResourceNotFoundException() {
        super("Resource not found.");
    }
    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
