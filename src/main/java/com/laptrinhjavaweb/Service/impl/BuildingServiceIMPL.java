package com.laptrinhjavaweb.Service.impl;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import com.laptrinhjavaweb.Convertor.BuildingConvertor;
import com.laptrinhjavaweb.Service.BuildingService;
import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.enity.BuildingEntity;
import com.laptrinhjavaweb.enums.DistrictEnum;
import com.laptrinhjavaweb.enums.TypeOfBuildingEnum;
import com.laptrinhjavaweb.enums.TypeOfTransactionEnum;
import com.laptrinhjavaweb.repository.JDBC.BuildingRepository;
import com.laptrinhjavaweb.repository.JDBC.impl.BuildingRepositoryIMPL;

public class BuildingServiceIMPL implements BuildingService {
	
	private BuildingRepository buildingRepository = new BuildingRepositoryIMPL();
	private BuildingConvertor buildingConvetor = new BuildingConvertor();
	

	@Override
	public List<BuildingDTO> getBuildings(BuildingSearchBuilder buildingSearchBuilder) {
		List<BuildingEntity> listBuildingEntitie = buildingRepository.getBuildings(buildingSearchBuilder);
		List<BuildingDTO> listBuildingDTO = new ArrayList<BuildingDTO>();
		BuildingDTO buildingDTO = new BuildingDTO();
		for (BuildingEntity buildingEntity : listBuildingEntitie) {
			buildingDTO = buildingConvetor.convertToBuildingDTO(buildingEntity);
			listBuildingDTO.add(buildingDTO);
		}
		return listBuildingDTO;
	}

	@Override
	public BuildingDTO saveBuilding(BuildingDTO buildingDTO) {
		buildingDTO.setRentAreas(buildingDTO.getRentArea().split(","));
		BuildingDTO buildingDTOResult = new BuildingDTO();
		long id = buildingRepository.saveWithTransaction(buildingDTO);
		buildingDTOResult = buildingConvetor.convertToBuildingDTO(buildingRepository.findById(id));
		return buildingDTOResult;
	}

	
	

	@Override
	public EnumMap<com.laptrinhjavaweb.enums.TypeOfBuildingEnum, String> getTypeOfBuildings() {
		EnumMap<com.laptrinhjavaweb.enums.TypeOfBuildingEnum, String> map = new EnumMap<com.laptrinhjavaweb.enums.TypeOfBuildingEnum, String>(com.laptrinhjavaweb.enums.TypeOfBuildingEnum.class);
		for (TypeOfBuildingEnum typeOfBuilding : TypeOfBuildingEnum.values()) {
			map.put(typeOfBuilding, typeOfBuilding.getValue());
		}
		return map;
	}

	@Override
	public EnumMap<DistrictEnum, String> getdistricts() {
		EnumMap<com.laptrinhjavaweb.enums.DistrictEnum, String> map = new EnumMap<com.laptrinhjavaweb.enums.DistrictEnum, String>(com.laptrinhjavaweb.enums.DistrictEnum.class);
		for (DistrictEnum district : DistrictEnum.values()) {
			map.put(district, district.getValue());
		}
		return map;
	}

	@Override
	public EnumMap<TypeOfTransactionEnum, String> getTypeOfTransaction() {
		EnumMap<com.laptrinhjavaweb.enums.TypeOfTransactionEnum, String> map = new EnumMap<com.laptrinhjavaweb.enums.TypeOfTransactionEnum, String>(com.laptrinhjavaweb.enums.TypeOfTransactionEnum.class);
		for (TypeOfTransactionEnum typeOfTransaction : TypeOfTransactionEnum.values()) {
			map.put(typeOfTransaction, typeOfTransaction.getValue());
		}
		return map;
	}

	
	
	

}
