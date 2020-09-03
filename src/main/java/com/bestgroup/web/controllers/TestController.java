package com.bestgroup.web.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.bestgroup.business.domain.Permission;

/**
* TestController
*/
@Path("/test")
public class TestController {

	@GET
	@Transactional
	public String test() { 
		return "test";
	}
	
}
