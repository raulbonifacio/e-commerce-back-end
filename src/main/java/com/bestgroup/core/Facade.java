package com.bestgroup.core;

import java.util.HashMap;
import java.util.Map;

import com.bestgroup.core.exception.FacadeException;

public abstract class Facade {

	protected enum Operation {
		CREATE, READ, UPDATE, DELETE;
	}

	protected Map<Class<? extends Entity>, Map<Operation, Handler>> mappedOperations = new HashMap<>();

	public Result performOn(Operation operation, Entity entity) throws FacadeException {

		Payload payload = new Payload(entity);

		if (!this.mappedOperations.containsKey(entity.getClass())) {
			throw new FacadeException("The class is not registered in the facade.");
		} else if (!this.mappedOperations.get(entity.getClass()).containsKey(operation)) {
			throw new FacadeException("The operation is not registered for the requested class.");
		}

		return this.mappedOperations.get(entity.getClass()).get(operation).handle(payload);
	}

	public Result create(Entity entity) throws FacadeException {
		return this.performOn(Operation.CREATE, entity);
	}

	public Result update(Entity entity) throws FacadeException {
		return this.performOn(Operation.UPDATE, entity);
	}

	public Result delete(Entity entity) throws FacadeException {
		return this.performOn(Operation.DELETE, entity);
	}

	public Result read(Entity entity) throws FacadeException {
		return this.performOn(Operation.READ, entity);
	}

}
