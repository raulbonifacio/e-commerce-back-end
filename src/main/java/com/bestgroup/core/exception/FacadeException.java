package com.bestgroup.core.exception;

public class FacadeException extends Exception {

	private static final long serialVersionUID = 1L;

	public FacadeException(String message) {
		super(message);
	}

	public FacadeException(Throwable throwable) { 
		super(throwable);
	}

}

