package com.bestgroup.core;

import java.util.Map;

public interface Result<E, R> {

	public Map<String, E> getErrors();

	public Map<String, R> getResults();
}
