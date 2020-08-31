package com.laptrinhjavaweb.Service;

import java.util.EnumMap;
import java.util.List;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.enums.DistrictEnum;
import com.laptrinhjavaweb.enums.TypeOfBuildingEnum;
import com.laptrinhjavaweb.enums.TypeOfTransactionEnum;

public interface BuildingService {
	List<BuildingDTO> getBuildings(BuildingSearchBuilder buildingSearchBuilder);
	BuildingDTO saveBuilding(BuildingDTO buildingDTO);
	
	
	/*// get type of building use constant
		List<String> getTypeOfBuilding();
		
	// get list district use constant
		List<String> getDistricts();*/
		
	// get type of building user enum
	EnumMap<TypeOfBuildingEnum, String> getTypeOfBuildings();
		
	EnumMap<DistrictEnum, String> getdistricts();
	EnumMap<TypeOfTransactionEnum, String> getTypeOfTransaction();
}
