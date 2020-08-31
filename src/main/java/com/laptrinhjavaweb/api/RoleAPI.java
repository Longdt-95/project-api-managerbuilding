package com.laptrinhjavaweb.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.Service.RoleService;
import com.laptrinhjavaweb.Service.impl.RoleServiceIMPL;
import com.laptrinhjavaweb.dto.RoleDTO;

@RestController
public class RoleAPI {
	
	private RoleService roleservice = new RoleServiceIMPL();
	
	@PostMapping("/role") 
	public RoleDTO getRole(@RequestBody RoleDTO roleDTO) {
		RoleDTO roleDTO1 = roleservice.saveRole(roleDTO);
		return roleDTO1;
	}
	
	@GetMapping("/listRoles")
	public List<RoleDTO> findAll() {
		List<RoleDTO> listResult = new ArrayList<>();
		listResult = roleservice.findAll();
		return listResult;
	}
	
	@PostMapping("/new-role")
	public int deleteRole(@RequestBody RoleDTO roleDTO) {
		int row = roleservice.deleteRole(roleDTO.getId());
		return row;
	}
	
}
