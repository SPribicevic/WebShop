package org.webshop.services;

import java.util.List;

import org.webshop.dao.IDAOAbstract;
import org.webshop.entities.BasicEntity;

public abstract class ServiceAbstract<T extends BasicEntity, DAO extends IDAOAbstract<T>> implements IServiceAbstract<T>{
	
	public ServiceAbstract(DAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	@Override
	public boolean add(T object) {
		// TODO Auto-generated method stub
		return this.dao.add(object);
	}

	@Override
	public boolean removeById(int id) {
		// TODO Auto-generated method stub
		return this.dao.reomoveById(id);
	}

	@Override
	public boolean update(T object) {
		// TODO Auto-generated method stub
		return this.dao.update(object);
	}

	@Override
	public List<T> getAll() {
		// TODO Auto-generated method stub
		return this.dao.getAll();
	}

	@Override
	public T getById(int id) {
		// TODO Auto-generated method stub
		return this.dao.getById(id);
	}

	private DAO dao;
}
