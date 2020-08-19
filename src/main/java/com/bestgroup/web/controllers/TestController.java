package com.bestgroup.web.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/test")
public class TestController { 

	@GET
	public String index() { 
		return "Hello there";
	}
}

