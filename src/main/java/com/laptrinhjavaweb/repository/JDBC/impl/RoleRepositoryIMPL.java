package com.laptrinhjavaweb.repository.JDBC.impl;

import java.util.List;

import com.laptrinhjavaweb.enity.RoleEntity;
import com.laptrinhjavaweb.repository.JDBC.RoleRepository;

public class RoleRepositoryIMPL extends SimpleJpaRepositoryIMPL<RoleEntity> implements RoleRepository {

	@Override
	public RoleEntity saveRole(RoleEntity roleEntity) {
		RoleEntity newRoleEntity = new RoleEntity();
		long id = save(roleEntity);
		newRoleEntity = findById(id);
		return newRoleEntity;
	}

	@Override
	public List<RoleEntity> findAllRole() {
		return findAll();
	}

	@Override
	public boolean updateRole(RoleEntity roleEntity) {
		return update(roleEntity);
	}

}
