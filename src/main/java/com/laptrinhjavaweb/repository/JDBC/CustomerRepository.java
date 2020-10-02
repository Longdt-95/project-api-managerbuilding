package com.laptrinhjavaweb.repository.JDBC;

import java.util.List;

import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.enity.CustomerEntity;

public interface CustomerRepository extends SimpleJpaRepository<CustomerEntity>{

	List<CustomerEntity> getAll(long userId, String code);
	List<CustomerEntity> getCustomersSearch(CustomerSearchBuilder customerSearchBuilder);
	long saveCustomer(CustomerEntity customerEntity);
	boolean updateCustomer(CustomerEntity customerEntity);
	boolean delWithTransaction(long longId);
}
