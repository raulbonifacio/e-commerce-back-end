package com.bestgroup.web.controllers;

import java.util.Objects;
import java.util.function.Supplier;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bestgroup.core.DomainEntity;
import com.bestgroup.core.Facade;
import com.bestgroup.core.Pagination;
import com.bestgroup.core.Payload;
import com.bestgroup.core.Result;
import com.bestgroup.core.exception.FacadeException;

public class FacadeController<T extends DomainEntity> {

	@Context
	protected HttpHeaders headers;

	@Inject
	protected Facade facade;

	@FunctionalInterface
	protected interface FacadeMethod {
		public Result perform(Facade facade, Payload payload) throws FacadeException;
	}

	protected Supplier<T> entitySupplier;

	public FacadeController(Supplier<T> entitySupplier) {
		this.entitySupplier = entitySupplier;
	}

	protected Response performFacadeMethod(FacadeMethod method, DomainEntity entity) {

		try {

			Payload payload = new Payload(entity);
			payload.setPagination(new Pagination());
			Result result = method.perform(this.facade, payload);

			return Response.ok(result).build();

		} catch (Exception exception) {
			throw new WebApplicationException(exception);
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(T entity) {
		entity = Objects.requireNonNullElse(entity, entitySupplier.get());
		return this.performFacadeMethod(Facade::create, entity);
	}

	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)

	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Long id, T entity) {
		entity = Objects.requireNonNullElse(entity, entitySupplier.get());
		entity.setId(id);
		entity.setId(id);
		return this.performFacadeMethod(Facade::update, entity);
	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") Long id, T entity) {
		entity = Objects.requireNonNullElse(entity, entitySupplier.get());
		entity.setId(id);
		return this.performFacadeMethod(Facade::delete, entity);
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response read(@PathParam("id") Long id, T entity) {
		entity = Objects.requireNonNullElse(entity, entitySupplier.get());
		entity.setId(id);
		return this.performFacadeMethod(Facade::read, entity);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response read(T entity, @QueryParam("pageNumber") int pageNumber, @QueryParam("pageSize") int pageSize) {

		entity = Objects.requireNonNullElse(entity, entitySupplier.get());

		return this.performFacadeMethod((facade, payload) -> {

			System.out.println(pageSize);
			System.out.println(pageNumber);

			Pagination pagination = payload.getPagination();
			pagination.setPageSize(pageSize);
			pagination.setPageNumber(pageNumber);

			return facade.read(payload);
		}, entity);
	}

}
