package com.laptrinhjavaweb.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.Service.CustomerService;
import com.laptrinhjavaweb.Service.TransactionService;
import com.laptrinhjavaweb.Service.UserService;
import com.laptrinhjavaweb.Service.impl.UserServiceIMPL;
import com.laptrinhjavaweb.dto.AssignmentCustomerDTO;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.dto.UserDTO;

@RestController
public class CustomerAPI {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private TransactionService transactionService;
	private UserService userService = new UserServiceIMPL();

	@GetMapping("cumstomers")
	public List<CustomerDTO> getAll(@RequestParam long userId, String code) {
		return customerService.getAll(userId, code);
	}

	@GetMapping("custumers/resultsearch")
	public List<CustomerDTO> GetCustomersSearch(@RequestParam(required = false) Map<String, String> requestParam) {
		return customerService.getCustomersSearch(requestParam);
	}

	@PostMapping("customer/add")
	public CustomerDTO saveCustomer(@RequestBody CustomerDTO dto) {
		return customerService.saveCustomer(dto);
	}

	@PutMapping("customer/edit")
	public boolean updateCustomer(@RequestBody CustomerDTO customerDTO) {
		return customerService.updateCustomer(customerDTO);
	}

	@DeleteMapping("customer/delete")
	public boolean delCustomer(@RequestParam long[] customerIds) {
		return customerService.delCustomer(customerIds);
	}

	@GetMapping("customer/staff")
	public List<UserDTO> getStaffs(@RequestParam long customerId, @RequestParam String role) {
		List<UserDTO> listResult = userService.findAllStaffAssignCustomer(customerId, role);
		return listResult;
	}
	
	@PostMapping("customer/transaction")
	public TransactionDTO saveTransaction(@RequestBody TransactionDTO dto) {
		return transactionService.saveTransaction(dto);
	}
	
	@GetMapping("customer/detail")
	public CustomerDTO getCustomerDetail(@RequestParam long customerId) {
		return customerService.getCustomerById(customerId);
	}
	
	@PostMapping("customer/assign")
	public boolean addAssignCustomer(@RequestBody(required = false) AssignmentCustomerDTO assignmentcustomer) {
		return customerService.updateAssign(assignmentcustomer);
	}
	
}
