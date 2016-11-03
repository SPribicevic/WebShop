package org.webshop.services;

import org.webshop.dao.IDAOProduct;
import org.webshop.entities.Product;

public class ServiceProduct extends ServiceAbstract<Product, IDAOProduct> implements IServiceProduct{

	public ServiceProduct(IDAOProduct dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}
}
