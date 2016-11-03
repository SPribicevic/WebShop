package org.webshop.auxiliary;

import org.webshop.entities.Product;

public class ShoppingCartItem extends Product{
	private Integer count;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
}
