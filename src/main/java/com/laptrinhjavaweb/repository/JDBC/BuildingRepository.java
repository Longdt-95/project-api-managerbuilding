package com.laptrinhjavaweb.repository.JDBC;

import java.util.List;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.enity.BuildingEntity;

public interface BuildingRepository extends SimpleJpaRepository<BuildingEntity>{
	List<BuildingEntity> getBuildings(BuildingSearchBuilder buildingSearchBuilder);
	long saveWithTransaction(BuildingEntity buildingEntity, String[] rentArea);
	BuildingEntity findById(long id);
	boolean updateWithTransaction(BuildingEntity buildingEntity, List<Integer> rentArea);
	boolean deleteWithTransaction(long id);
	List<BuildingEntity> findAllBuildingsByStaffId(long staffId);
	List<BuildingEntity> getBuildingsPrioritize(long staffId, String prioritize);
	
}
