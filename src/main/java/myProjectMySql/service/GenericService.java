package myProjectMySql.service;

import java.util.List;

public interface GenericService <T>{
	public List<T> getAll();
	public T get(String id);
	public void add(T t);
	public void update(T t);
	public void delete(String id);
}
