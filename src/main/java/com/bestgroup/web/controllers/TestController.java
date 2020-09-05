package com.bestgroup.web.controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bestgroup.business.domain.Permission;
@Path("/test")
public class TestController {

	@PersistenceUnit(unitName="MySQL")
	EntityManagerFactory entityManagerFactory;

	@GET
	@Transactional
	@Produces(MediaType.APPLICATION_JSON)
	public Permission test() {

		EntityManager em = entityManagerFactory.createEntityManager();

		Permission permission = new Permission();

		em.persist(permission);

		return permission;
	}

}
