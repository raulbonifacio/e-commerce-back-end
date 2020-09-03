package com.bestgroup.core;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import com.bestgroup.core.exception.FacadeException;
import com.bestgroup.core.exception.HandlerException;

public abstract class Facade {

	protected enum Operation {
		CREATE, READ, UPDATE, DELETE;
	}

	protected Map<Class<? extends DomainEntity>, Map<Operation, Handler>> mappedOperations = new HashMap<>();

	@Transactional
	protected Result perform(Operation operation, DomainEntity entity) throws FacadeException, HandlerException {

		Payload payload = new Payload(entity);

		if (!this.mappedOperations.containsKey(entity.getClass())) {
			throw new FacadeException("The entity type is not registered in the facade.");
		} else if (!this.mappedOperations.get(entity.getClass()).containsKey(operation)) {
			throw new FacadeException("The operation is not registered for the requested entity type.");
		}

		return this.mappedOperations.get(entity.getClass()).get(operation).handle(payload);
	}

	public Result create(DomainEntity entity) throws FacadeException, HandlerException {
		return this.perform(Operation.CREATE, entity);
	}

	public Result update(DomainEntity entity) throws FacadeException, HandlerException {
		return this.perform(Operation.UPDATE, entity);
	}

	public Result delete(DomainEntity entity) throws FacadeException, HandlerException {
		return this.perform(Operation.DELETE, entity);
	}

	public Result read(DomainEntity entity) throws FacadeException, HandlerException {
		return this.perform(Operation.READ, entity);
	}

	protected void onOperation(Operation operation, Class<? extends DomainEntity> entityClass, Handler handler) {
		this.mappedOperations.putIfAbsent(entityClass, new HashMap<>());
		this.mappedOperations.get(entityClass).putIfAbsent(operation, handler);
	}

	public void onCreate(Class<? extends DomainEntity> entityClass, Handler handler) {
		this.onOperation(Operation.CREATE, entityClass, handler);
	}

	public void onUpdate(Class<? extends DomainEntity> entityClass, Handler handler) {
		this.onOperation(Operation.UPDATE, entityClass, handler);
	}

	public void onDelete(Class<? extends DomainEntity> entityClass, Handler handler) {
		this.onOperation(Operation.DELETE, entityClass, handler);
	}

	public void onRead(Class<? extends DomainEntity> entityClass, Handler handler) {
		this.onOperation(Operation.READ, entityClass, handler);
	}
}
