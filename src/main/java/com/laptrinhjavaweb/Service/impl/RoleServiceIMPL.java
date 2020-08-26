package com.laptrinhjavaweb.Service.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.Convertor.RoleConvertor;
import com.laptrinhjavaweb.Service.RoleService;
import com.laptrinhjavaweb.dto.RoleDTO;
import com.laptrinhjavaweb.enity.RoleEntity;
import com.laptrinhjavaweb.repository.JDBC.RoleRepository;
import com.laptrinhjavaweb.repository.JDBC.impl.RoleRepositoryIMPL;

public class RoleServiceIMPL implements RoleService {
	
	private RoleRepository roleRepository = new RoleRepositoryIMPL();
	private RoleConvertor roleConvertor = new RoleConvertor();

	@Override
	public RoleDTO saveRole(RoleDTO roleDTO) {
		RoleEntity roleEntity = roleConvertor.convertToRoleEntity(roleDTO);
		long id = roleRepository.save(roleEntity);
		roleEntity = roleRepository.findById(id);
		roleDTO = roleConvertor.convertToRoleDTO(roleEntity);
		return roleDTO;
	}

	@Override
	public List<RoleDTO> findAll() {
		List<RoleDTO> listRoles = new ArrayList<>();
		RoleDTO roleDTO = new RoleDTO();
		for (RoleEntity roleEntity : roleRepository.findAllRole()) {
			roleDTO = roleConvertor.convertToRoleDTO(roleEntity);
			listRoles.add(roleDTO);
		}
		return listRoles;
	}



}
