package com.laptrinhjavaweb.Service;

import java.util.List;

import com.laptrinhjavaweb.dto.UserDTO;

public interface UserService{
	List<UserDTO> findAllStaff(long id, String role);
}
