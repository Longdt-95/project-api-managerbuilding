package com.laptrinhjavaweb.Service;

import java.util.List;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;

public interface BuildingService {
	List<BuildingDTO> getBuildings(BuildingSearchBuilder buildingSearchBuilder);
	BuildingDTO saveBuilding(BuildingDTO buildingDTO);
	boolean updateBuilding(BuildingDTO buildingDTO);
	boolean delBuilding(long buildingId);
	BuildingDTO getBuilding(long id);
	List<BuildingDTO> getListBuildingByStaffId(long staffId);
	List<BuildingDTO> getBuildingsPrioritize(long staffId, String prioritize);
}
