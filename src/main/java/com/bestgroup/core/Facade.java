package com.bestgroup.core;

import java.util.HashMap;
import java.util.Map;

import com.bestgroup.core.exception.FacadeException;
import com.bestgroup.core.exception.HandlerException;

public abstract class Facade {

	protected enum Operation {
		CREATE, READ, UPDATE, DELETE;
	}

	protected Map<Class<? extends Entity>, Map<Operation, Handler>> mappedOperations = new HashMap<>();

	public Result perform(Operation operation, Entity entity) throws FacadeException, HandlerException {

		Payload payload = new Payload(entity);

		if (!this.mappedOperations.containsKey(entity.getClass())) {
			throw new FacadeException("The entity type is not registered in the facade.");
		} else if (!this.mappedOperations.get(entity.getClass()).containsKey(operation)) {
			throw new FacadeException("The operation is not registered for the requested entity type.");
		}

		return this.mappedOperations.get(entity.getClass()).get(operation).handle(payload);
	}

	public Result create(Entity entity) throws FacadeException, HandlerException {
		return this.perform(Operation.CREATE, entity);
	}

	public Result update(Entity entity) throws FacadeException, HandlerException {
		return this.perform(Operation.UPDATE, entity);
	}

	public Result delete(Entity entity) throws FacadeException, HandlerException {
		return this.perform(Operation.DELETE, entity);
	}

	public Result read(Entity entity) throws FacadeException, HandlerException {
		return this.perform(Operation.READ, entity);
	}

	public void onOperation(Operation operation, Class<? extends Entity> entityClass, Handler handler) {
		this.mappedOperations.putIfAbsent(entityClass, new HashMap<>());
		this.mappedOperations.get(entityClass).putIfAbsent(operation, handler);
	}

	public void onCreate(Class<? extends Entity> entityClass, Handler handler) {
		this.onOperation(Operation.CREATE, entityClass, handler);
	}

	public void onUpdate(Class<? extends Entity> entityClass, Handler handler) {
		this.onOperation(Operation.UPDATE, entityClass, handler);
	}

	public void onDelete(Class<? extends Entity> entityClass, Handler handler) {
		this.onOperation(Operation.DELETE, entityClass, handler);
	}

	public void onRead(Class<? extends Entity> entityClass, Handler handler) {
		this.onOperation(Operation.READ, entityClass, handler);
	}
}
