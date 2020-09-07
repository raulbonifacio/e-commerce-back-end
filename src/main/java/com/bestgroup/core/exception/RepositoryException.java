package com.bestgroup.core.exception;

public class RepositoryException extends Exception {

	private static final long serialVersionUID = 1L;

	public RepositoryException(String message) { 
		super(message); 
	}
	
	public RepositoryException(Throwable throwable) { 
		super(throwable);
	}

}
