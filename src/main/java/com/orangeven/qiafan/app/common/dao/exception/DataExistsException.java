package com.orangeven.qiafan.app.common.dao.exception;

public class DataExistsException extends AbstractDaoException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6751381566146620014L;

	public DataExistsException() {
        super("Data already exist.");
    }

    public DataExistsException(String msg) {
        super(msg);
    }

}
