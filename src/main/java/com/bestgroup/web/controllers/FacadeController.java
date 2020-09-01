package com.bestgroup.web.controllers;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bestgroup.core.Entity;
import com.bestgroup.core.Facade;
import com.bestgroup.core.Result;
import com.bestgroup.core.exception.FacadeException;
import com.bestgroup.core.exception.HandlerException;

public class FacadeController<T extends Entity> {

	@Inject
	protected Facade facade;

	@FunctionalInterface
	protected interface FacadeMethod {
		public Result perform(Facade facade, Entity entity) throws FacadeException, HandlerException;
	}

	protected Response performFacadeMethod(FacadeMethod method, Entity entity) {
		try {
			return Response.ok(method.perform(this.facade, entity)).build();
		} catch (Exception exception) {
			//return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(exception).build();
			throw new WebApplicationException(exception);
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(T entity) {
		return this.performFacadeMethod(Facade::create, entity);
	}

	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Integer id, T entity) {
		entity.setId(id);
		return this.performFacadeMethod(Facade::update, entity);
	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") Integer id, T entity) {
		entity.setId(id);
		return this.performFacadeMethod(Facade::delete, entity);
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response read(@PathParam("id") Integer id, T entity) {
		entity.setId(id);
		return this.performFacadeMethod(Facade::read, entity);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response read(T entity) {
		return this.performFacadeMethod(Facade::read, entity);
	}

}
