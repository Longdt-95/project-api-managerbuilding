package com.laptrinhjavaweb.Convertor;

import org.modelmapper.ModelMapper;

import com.laptrinhjavaweb.dto.RoleDTO;
import com.laptrinhjavaweb.enity.RoleEntity;

public class RoleConvertor {
	ModelMapper modelMapper = new ModelMapper();
	public RoleDTO convertToRoleDTO(RoleEntity roleEntity ) {
		RoleDTO roleDTO = modelMapper.map(roleEntity, RoleDTO.class);
		return roleDTO;
	}
	
	public RoleEntity convertToRoleEntity(RoleDTO roleDTO) {
		RoleEntity roleEntity = modelMapper.map(roleDTO, RoleEntity.class);
		return roleEntity;
	}
}
