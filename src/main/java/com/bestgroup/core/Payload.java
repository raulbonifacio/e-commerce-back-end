package com.bestgroup.core;

import javax.json.bind.annotation.JsonbTransient;

public class Payload extends Result {

	protected Entity entity;

	public Payload(Entity entity) {
		this.entity = entity;
	}

	@JsonbTransient
	public Entity getEntity() {
		return this.entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

}
