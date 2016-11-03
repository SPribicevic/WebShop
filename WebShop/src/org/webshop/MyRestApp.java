package org.webshop;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.webshop.controllers.ControllerProduct;
import org.webshop.controllers.ControllerTransaction;
import org.webshop.controllers.ControllerUser;

@ApplicationPath("/rest")
public class MyRestApp extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(ControllerUser.class);
		classes.add(ControllerProduct.class);
		classes.add(ControllerTransaction.class);
		return classes;
	}
}
