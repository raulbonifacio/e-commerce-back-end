package com.bestgroup.core;

import javax.json.bind.annotation.JsonbTransient;

public class Payload extends Result {

	protected DomainEntity entity;
	protected Pagination pagination;

	public Payload(final DomainEntity entity) {
		this.entity = entity;
	}

	@JsonbTransient
	public DomainEntity getEntity() {
		return entity;
	}

	public void setEntity(DomainEntity entity) {
		this.entity = entity;
	}

	@JsonbTransient
	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

}
