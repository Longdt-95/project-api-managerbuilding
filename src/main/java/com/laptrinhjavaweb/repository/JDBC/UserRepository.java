package com.laptrinhjavaweb.repository.JDBC;

import java.util.List;

import com.laptrinhjavaweb.enity.UserEntity;

public interface UserRepository extends SimpleJpaRepository<UserEntity>{
	List<UserEntity> findAllUser();
	List<UserEntity> getUsersAssignmentBuildingByBuildingID(long id);
}
