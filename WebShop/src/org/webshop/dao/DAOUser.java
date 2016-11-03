package org.webshop.dao;

import org.webshop.entities.User;

public class DAOUser extends DAOAbstractDatabase<User> implements IDAOUser{
	
	public DAOUser() {
		super(User.class);
	}
	
}
