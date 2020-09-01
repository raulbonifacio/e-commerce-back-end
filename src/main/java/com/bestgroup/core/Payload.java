package com.bestgroup.core;

public class Payload extends Result {

	protected Entity entity;

	public Payload(Entity entity) {
		this.entity = entity;
	}

	public Entity getEntity() {
		return this.entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

}
