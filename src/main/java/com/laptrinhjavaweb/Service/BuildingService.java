package com.laptrinhjavaweb.Service;

import java.util.EnumMap;
import java.util.List;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.enums.DistrictEnum;
import com.laptrinhjavaweb.enums.BuildingTypeEnum;
import com.laptrinhjavaweb.enums.TransactionTypeEnum;

public interface BuildingService {
	List<BuildingDTO> getBuildings(BuildingSearchBuilder buildingSearchBuilder);
	BuildingDTO saveBuilding(BuildingDTO buildingDTO);
	
	
	/*// get type of building use constant
		List<String> getTypeOfBuilding();
		
	// get list district use constant
		List<String> getDistricts();*/
		
	// get type of building user enum
	EnumMap<BuildingTypeEnum, String> getTypeOfBuildings();
		
	EnumMap<DistrictEnum, String> getdistricts();
	EnumMap<TransactionTypeEnum, String> getTypeOfTransaction();
}
