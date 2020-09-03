package com.bestgroup.core;

import javax.json.bind.annotation.JsonbTransient;

public class Payload extends Result {

	protected DomainEntity entity;

	public Payload(DomainEntity entity) {
		this.entity = entity;
	}

	@JsonbTransient
	public DomainEntity getDomainEntity() {
		return this.entity;
	}

	public void setDomainEntity(DomainEntity entity) {
		this.entity = entity;
	}

}
