package org.webshop.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.webshop.auxiliary.LoginResponse;
import org.webshop.dao.IDAOUser;
import org.webshop.entities.User;

public class ServiceUser extends ServiceAbstract<User, IDAOUser> implements IServiceUser{
	
	public ServiceUser(IDAOUser dao) {
		super(dao);
	}

	@Override
	public LoginResponse login(User user, HttpServletRequest req) { 
		LoginResponse lr;
		List<User> users;
		HttpSession session;
		String username;
		String password = null;
		boolean status;
		String message;
		User uu = null;
		
		session = req.getSession();
		username = (String) session.getAttribute("username");
		if(username != null) {
			status = false;
			message = "User already logged in!";
		} else {
			users = this.getAll();
			/*if(users == null){
				System.out.println("Null users!");
				return(new LoginResponse());
			}*/
			for(User u : users){
				if(u.getUsername().equals(user.getUsername())) {
					username = u.getUsername();
					password = u.getPassword();
					uu = u;
					break;
				}
			}
			if(username == null) {
				status = false;
				message = "No such username!";
			} else {
				if(!password.equals(user.getPassword())) {
					status = false;
					message = "Incorrect password!";
				} else {
					status = true;
					message = "Login successfull!";
					session.setAttribute("username", username);
					session.setAttribute("user", uu);
				}
			}
		}
		
		return new LoginResponse(status, message);
	}

	@Override
	public void logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		
	}

	@Override
	public LoginResponse verifyUser(User user, HttpServletRequest req) {
		HttpSession session = req.getSession();
		boolean status;
		String message;
		User u;
		
		System.out.println(user.getName());
		
		if(session.getAttribute("user") == null){
			status = false;
			message = "User not logged in!";
		} else {
			u = (User) session.getAttribute("user");
			if(!u.getName().equals(user.getName())) {
				status = false;
				message = "Wrong name!";
			} else {
				if(!u.getSurname().equals(user.getSurname())) {
					status = false;
					message = "Wrong surname!";
				} else {
					if(u.getCard_no() - user.getCard_no() != 0) {
						System.out.println(u.getCard_no() + "   " + user.getCard_no());
						status = false;
						message = "Wrong card number!";
					} else {
						status = true;
						message = "Transaction transmited successfully";
					}
				}
			}
		}
		
		System.out.println(message);
		
		return new LoginResponse(status, message);
	}
}
