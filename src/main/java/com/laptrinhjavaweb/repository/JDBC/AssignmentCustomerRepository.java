package com.laptrinhjavaweb.repository.JDBC;

import java.util.List;

public interface AssignmentCustomerRepository {

	List<Long> getStaffIds(long customerId);

	boolean assignCustomer(List<Long> isCheckedUsers, List<Long> unCheckedUsers, long customerId);

}
