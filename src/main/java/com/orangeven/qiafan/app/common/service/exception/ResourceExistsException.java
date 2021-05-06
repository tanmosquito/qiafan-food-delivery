package com.orangeven.qiafan.app.common.service.exception;

public class ResourceExistsException extends AbstractServiceException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7339670899207494198L;

	public ResourceExistsException() {
        super("Resource already exists.");
    }

    public ResourceExistsException(String msg) {
        super(msg);
    }
}
