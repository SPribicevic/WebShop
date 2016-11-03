package org.webshop.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.webshop.auxiliary.LoginResponse;
import org.webshop.dao.DAOUser;
import org.webshop.dao.IDAOUser;
import org.webshop.entities.User;
import org.webshop.services.IServiceUser;
import org.webshop.services.ServiceUser;

@Path("/user")
public class ControllerUser {
	
	public ControllerUser() {
		this.service = new ServiceUser(new DAOUser());
	}
	
	@POST
	@Produces("text/json")
	public LoginResponse login(User user, @Context HttpServletRequest req) {
		return service.login(user,req);
	}
	
	@POST
	@Path("/verifyuser")
	@Produces("text/json")
	public LoginResponse verifyUser(User user, @Context HttpServletRequest req) {
		System.out.println(user.getName());
		return service.verifyUser(user, req);
	}
	
	@GET
	public void logout(@Context HttpServletRequest req) {
		service.logout(req);
	}
	
	private IServiceUser service;
}
