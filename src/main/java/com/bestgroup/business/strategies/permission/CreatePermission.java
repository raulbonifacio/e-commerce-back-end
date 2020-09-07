package com.bestgroup.business.strategies.permission;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import com.bestgroup.business.domain.Permission;
import com.bestgroup.core.Payload;
import com.bestgroup.core.Strategy;
import com.bestgroup.core.exception.StrategyException;

@Default
public class CreatePermission implements Strategy {

	@PersistenceUnit(unitName = "MySQL")
	EntityManagerFactory entityManagerFactory;

	@Override
	public Payload onPayload(Payload payload) throws StrategyException {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Permission permission = (Permission) payload.getEntity();

		entityManager.persist(permission);
		
		payload.getEntities().add(permission);

		return payload;
	}

}
