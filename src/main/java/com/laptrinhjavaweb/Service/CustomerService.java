package com.laptrinhjavaweb.Service;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.dto.AssignmentCustomerDTO;
import com.laptrinhjavaweb.dto.CustomerDTO;

public interface CustomerService {

	List<CustomerDTO> getAll();
	List<CustomerDTO> getAll(long userId, String code);
	List<CustomerDTO> getCustomersSearch(Map<String, String> requestParam);
	CustomerDTO saveCustomer(CustomerDTO dto);
	boolean updateCustomer(CustomerDTO customerDTO);
	boolean delCustomer(long[] customerIds);
	CustomerDTO getCustomerById(long customerId);
	boolean updateAssign(AssignmentCustomerDTO assignmentcustomer);
}
