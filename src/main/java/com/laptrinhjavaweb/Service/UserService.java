package com.laptrinhjavaweb.Service;

import java.util.List;

import com.laptrinhjavaweb.dto.UserDTO;

public interface UserService{
	
	List<UserDTO> findAllStaffAssignBuilding(long id, String role);

	List<UserDTO> findAllStaffAssignCustomer(long customerId, String role);
}
