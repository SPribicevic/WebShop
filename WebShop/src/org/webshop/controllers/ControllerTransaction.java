package org.webshop.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.webshop.auxiliary.ShoppingCartItem;
import org.webshop.dao.DAOTransaction;
import org.webshop.services.IServiceTransaction;
import org.webshop.services.ServiceTransaction;

@Path("/transaction")
public class ControllerTransaction {
	
	public ControllerTransaction() {
		this.service = new ServiceTransaction(new DAOTransaction());
	}
	
	@POST
	public void submitTransaction(List<ShoppingCartItem> items, @Context HttpServletRequest req) {
		this.service.submit(items, req);
	}
	
	private IServiceTransaction service;
}
