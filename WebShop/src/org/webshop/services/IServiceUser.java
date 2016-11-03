package org.webshop.services;

import javax.servlet.http.HttpServletRequest;

import org.webshop.auxiliary.LoginResponse;
import org.webshop.entities.User;

public interface IServiceUser extends IServiceAbstract<User>{
	
	public LoginResponse login(User user, HttpServletRequest req);
	public void logout(HttpServletRequest req);
	public LoginResponse verifyUser(User user, HttpServletRequest req);
}
