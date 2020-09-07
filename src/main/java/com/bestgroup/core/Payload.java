package com.bestgroup.core;

import javax.json.bind.annotation.JsonbTransient;

public class Payload extends Result {

	protected DomainEntity receivedEntity;
	protected Pagination pagination;

	public Payload(final DomainEntity receivedEntity) {
		this.receivedEntity = receivedEntity;
	}

	@JsonbTransient
	public DomainEntity getReceivedEntity() {
		return receivedEntity;
	}

	public void setEntity(DomainEntity receivedEntity) {
		this.receivedEntity = receivedEntity;
	}

	@JsonbTransient
	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

}
