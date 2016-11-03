package org.webshop.dao;

import org.webshop.entities.Product;

public class DAOProduct extends DAOAbstractDatabase<Product> implements IDAOProduct{
		
		public DAOProduct() {
			super(Product.class);
		}
	
}
