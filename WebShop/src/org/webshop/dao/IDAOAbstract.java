package org.webshop.dao;

import java.util.List;

import org.webshop.entities.BasicEntity;

public interface IDAOAbstract<T extends BasicEntity> {
	public boolean add(T object);
	public boolean reomoveById(int id);
	public boolean update(T object);
	public List<T> getAll();
	public T getById(int id);
}
