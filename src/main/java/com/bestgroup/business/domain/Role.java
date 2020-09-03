package com.bestgroup.business.domain;

import java.util.List;

import javax.persistence.Table;

@Table(name = "roles")
public class Role {

	protected String name;
	protected String description;
	protected List<Permission> permissions;

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

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

}
