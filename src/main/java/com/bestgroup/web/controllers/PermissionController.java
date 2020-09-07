package com.bestgroup.web.controllers;

import javax.ws.rs.Path;

import com.bestgroup.business.domain.Permission;

@Path("/permissions")
public class PermissionController extends FacadeController<Permission> {

	public PermissionController() {
		super(Permission::new);
	}

}
