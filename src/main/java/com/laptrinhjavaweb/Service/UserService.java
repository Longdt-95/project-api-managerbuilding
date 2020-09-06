package com.laptrinhjavaweb.Service;

import java.util.List;

import com.laptrinhjavaweb.dto.UserDTO;

public interface UserService{
	List<UserDTO> findAllUser(long id, String role);
}
