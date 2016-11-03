package org.webshop.controllers;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.webshop.dao.DAOProduct;
import org.webshop.entities.Product;
import org.webshop.services.IServiceProduct;
import org.webshop.services.ServiceProduct;

@Path("/product")
public class ControllerProduct {

	public ControllerProduct() {
		service = new ServiceProduct(new DAOProduct());
	}
	
	@GET
	@Produces("text/json")
	public List<Product> getAll() {
		return service.getAll();
	}
	
	private IServiceProduct service;
}
