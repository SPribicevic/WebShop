package org.webshop.dao;

import org.webshop.entities.Transaction;

public class DAOTransaction extends DAOAbstractDatabase<Transaction> implements IDAOTransaction{
	
	public DAOTransaction(){
		super(Transaction.class);
	}
	
}
