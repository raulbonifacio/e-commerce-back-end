package com.bestgroup.business.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.bestgroup.core.DomainEntity;

@Entity
public class Permission extends DomainEntity {

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