package com.laptrinhjavaweb.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.Service.UserService;
import com.laptrinhjavaweb.Service.impl.UserServiceIMPL;
import com.laptrinhjavaweb.dto.UserDTO;

@RestController
public class UserAPI {
	
	private UserService userService = new UserServiceIMPL();
	
	@GetMapping ("/list-staff-manager-building")
	public List<UserDTO> getListStaff(@RequestParam long  id, @RequestParam String code) {
		List<UserDTO> listResult = userService.findAllUser(id);
		return listResult;
	}
}
