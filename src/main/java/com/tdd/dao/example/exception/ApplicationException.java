package com.tdd.dao.example.exception;

public class ApplicationException extends Exception{

	private static final long serialVersionUID = -1000982878870266220L;
	

    public ApplicationException(final Throwable throwable) {
        super(throwable);
    }


    public ApplicationException(final String exceptionMessage) {
        super(exceptionMessage);
    }


    public ApplicationException(final String exceptionMessage, final Throwable throwable) {
        super(exceptionMessage, throwable);
    }

}
