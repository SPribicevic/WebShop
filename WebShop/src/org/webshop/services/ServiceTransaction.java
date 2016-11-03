package org.webshop.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.webshop.auxiliary.ShoppingCartItem;
import org.webshop.dao.DAOTransaction;
import org.webshop.entities.Transaction;
import org.webshop.entities.User;

public class ServiceTransaction extends ServiceAbstract<Transaction, DAOTransaction> implements IServiceTransaction{

	public ServiceTransaction(DAOTransaction dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void submit(List<ShoppingCartItem> items, HttpServletRequest req) {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		Integer userId = user.getId();
		Transaction transaction;
		
		for(ShoppingCartItem item : items) {
			transaction = new Transaction();
			transaction.setId_user(userId);
			transaction.setId_product(item.getId());
			transaction.setCount(item.getCount());
			this.add(transaction);
		}
		
	}

}
