package com.laptrinhjavaweb.repository.JDBC;

import java.util.List;

public interface SimpleJpaRepository<T> {
	
	long save(T t);
	T update(Object object);
	T findById(long id);
	List<T> findAll();
	
	
}
