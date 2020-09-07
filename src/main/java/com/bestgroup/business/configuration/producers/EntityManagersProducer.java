package com.bestgroup.business.configuration.producers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bestgroup.business.configuration.qualifiers.MySQLEntityManager;

@ApplicationScoped
public class EntityManagersProducer {

	@Produces
	@MySQLEntityManager
	@PersistenceContext(unitName = "MySQL")
	protected EntityManager entityManager;

}
