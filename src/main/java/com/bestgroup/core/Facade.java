package com.bestgroup.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import com.bestgroup.core.exception.FacadeException;
import static com.bestgroup.core.Facade.Operation.*;

public abstract class Facade {

	protected enum Operation {
		CREATE, READ, UPDATE, DELETE;
	}

	protected Map<Class<? extends DomainEntity>, Map<Operation, List<Strategy>>> mappedOperations = new HashMap<>();

	@Transactional
	protected Result perform(Operation operation, Payload payload) throws FacadeException {

		try {

			DomainEntity entity = payload.getReceivedEntity();

			if (payload.getReceivedEntity() == null) {
				throw new FacadeException("The payload entity cannot be empty.");
			} else if (!this.mappedOperations.containsKey(entity.getClass())) {
				throw new FacadeException("The entity type is not registered in the facade.");
			} else if (!this.mappedOperations.get(entity.getClass()).containsKey(operation)) {
				throw new FacadeException("The operation is not registered for the requested entity type.");
			}

			for (Strategy strategy : this.mappedOperations.get(entity.getClass()).get(operation)) {
				strategy.onPayload(payload);
			}

			return payload;

		} catch (Exception exception) {
			throw new FacadeException(exception);
		}
	}

	@Transactional
	public Result create(Payload payload) throws FacadeException {
		return this.perform(CREATE, payload);
	}

	@Transactional
	public Result update(Payload payload) throws FacadeException {
		return this.perform(UPDATE, payload);
	}

	@Transactional
	public Result delete(Payload payload) throws FacadeException {
		return this.perform(DELETE, payload);
	}

	@Transactional
	public Result read(Payload payload) throws FacadeException {
		return this.perform(READ, payload);
	}

	protected void onOperation(Operation operation, Class<? extends DomainEntity> entityClass,
			List<Strategy> strategies) {
		this.mappedOperations.putIfAbsent(entityClass, new HashMap<>());
		this.mappedOperations.get(entityClass).putIfAbsent(operation, strategies);
	}

	public void onCreate(Class<? extends DomainEntity> entityClass, List<Strategy> strategies) {
		this.onOperation(CREATE, entityClass, strategies);
	}

	public void onUpdate(Class<? extends DomainEntity> entityClass, List<Strategy> strategies) {
		this.onOperation(UPDATE, entityClass, strategies);
	}

	public void onDelete(Class<? extends DomainEntity> entityClass, List<Strategy> strategies) {
		this.onOperation(DELETE, entityClass, strategies);
	}

	public void onRead(Class<? extends DomainEntity> entityClass, List<Strategy> strategies) {
		this.onOperation(READ, entityClass, strategies);
	}
}
