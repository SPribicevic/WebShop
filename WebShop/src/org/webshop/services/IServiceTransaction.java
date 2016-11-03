package org.webshop.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.webshop.auxiliary.ShoppingCartItem;
import org.webshop.entities.Transaction;

public interface IServiceTransaction extends IServiceAbstract<Transaction>{

	void submit(List<ShoppingCartItem> items, HttpServletRequest req);

}
