package com.laptrinhjavaweb.Service;

import java.util.List;

import com.laptrinhjavaweb.dto.RoleDTO;

public interface RoleService {
	RoleDTO saveRole(RoleDTO roleDTO);

	List<RoleDTO> findAll();
}
