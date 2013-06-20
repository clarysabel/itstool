package com.openenglish.itstool.exception;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 5391220961750709573L;

	public BusinessException(String desc, Throwable cause) {
        super(desc, cause);
    }

    public BusinessException(String desc) {
        super(desc);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

}
