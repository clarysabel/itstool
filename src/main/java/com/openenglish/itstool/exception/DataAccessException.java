package com.openenglish.itstool.exception;

public class DataAccessException extends Exception {

	private static final long serialVersionUID = -4265930839461166144L;
	
	public DataAccessException(String desc, Throwable cause) {
        super(desc, cause);
    }

    public DataAccessException(String desc) {
        super(desc);
    }

}
