package com.laptrinhjavaweb.repository.JDBC;

import java.util.List;

public interface SimpleJpaRepository<T> {
	
	long save(T t);
	boolean update(Object object);
	int delete(long id);
	T findById(long id);
	List<T> findAll();
	List<T> findAll(String sql);
	int delete(String sql);
}
