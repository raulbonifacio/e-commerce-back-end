package com.bestgroup.business.modules.permission;

import com.bestgroup.core.Entity;

public class Permission extends Entity {

	protected String name;
	protected String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
