package com.orangeven.qiafan.app.common.dao.exception;

public class DataNotFoundException extends AbstractDaoException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4779364142074824682L;

	public DataNotFoundException() {
        super("Can not find the data.");
    }

    public DataNotFoundException(String msg) {
        super(msg);
    }

}
