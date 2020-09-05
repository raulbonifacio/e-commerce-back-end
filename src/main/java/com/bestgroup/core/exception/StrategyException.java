package com.bestgroup.core.exception;

public class StrategyException extends Exception {

	private static final long serialVersionUID = 1L;

	public StrategyException(String message) {
		super(message);
	}

	public StrategyException(Exception exception) { 
		super(exception);
	}
}
