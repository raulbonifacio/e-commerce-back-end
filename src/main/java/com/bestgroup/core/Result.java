package com.bestgroup.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {

	protected List<DomainEntity> entities = new ArrayList<>();

	protected Map<String, String> errors = new HashMap<>();

	public List<DomainEntity> getEntities() {
		return this.entities;
	}

	public Map<String, String> getErrors() {
		return this.errors;
	}
}
