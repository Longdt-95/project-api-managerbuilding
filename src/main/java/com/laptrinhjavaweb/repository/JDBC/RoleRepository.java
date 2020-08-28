package com.laptrinhjavaweb.repository.JDBC;

import java.util.List;

import com.laptrinhjavaweb.enity.RoleEntity;

public interface RoleRepository extends SimpleJpaRepository<RoleEntity> {
	RoleEntity saveRole(RoleEntity roleEntity);
	List<RoleEntity> findAllRole();
	boolean updateRole(RoleEntity roleEntity);
}
