package com.laptrinhjavaweb.repository.JDBC;

import java.util.List;

public interface SimpleJpaRepository<T> {
	
	long save(T t);
	boolean update(Object object);
	int delete(Object object);
	T findById(long id);
	List<T> findAll();
}
