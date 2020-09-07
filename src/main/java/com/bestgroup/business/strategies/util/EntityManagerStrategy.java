package com.bestgroup.business.strategies.util;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.bestgroup.business.configuration.qualifiers.MySQLEntityManager;
import com.bestgroup.core.Strategy;

public class EntityManagerStrategy implements Strategy {

	@Inject
	@MySQLEntityManager
	protected EntityManager entityManager;

	public EntityManagerStrategy() {
		// Does nothing...
	}

	public EntityManagerStrategy(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
