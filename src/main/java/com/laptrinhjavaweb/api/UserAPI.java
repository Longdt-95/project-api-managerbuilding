package com.laptrinhjavaweb.api;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.Service.UserService;
import com.laptrinhjavaweb.Service.impl.UserServiceIMPL;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.UserDTO;

@RestController
public class UserAPI {
	
	private UserService userService = new UserServiceIMPL();
	
	@PostMapping ("/list-staff-manager-building")
	public List<UserDTO> getListStaff(@RequestBody BuildingDTO buildingDTO) {
		List<UserDTO> listResult = userService.findAllUser(buildingDTO.getId());
		return listResult;
	}
}
