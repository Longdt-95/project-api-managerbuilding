package com.laptrinhjavaweb.repository.JDBC;

import java.util.List;

import com.laptrinhjavaweb.enity.UserEntity;

public interface UserRepository extends SimpleJpaRepository<UserEntity>{
	
	List<UserEntity> findAllStaff(String role);
	List<UserEntity> getUsersAssignmentBuildingByBuildingID(long id);
	boolean isAssignmentBuilding(long staffId, long buildingId);
	boolean isAssignmentCustomer(long staffId, long customerId);
}
