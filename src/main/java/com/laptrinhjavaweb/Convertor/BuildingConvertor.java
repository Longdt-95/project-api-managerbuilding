package com.laptrinhjavaweb.Convertor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.enity.BuildingEntity;

@Component
public class BuildingConvertor {
	
	ModelMapper modelMapper = new ModelMapper();
	
	public BuildingDTO convertToBuildingDTO(BuildingEntity buildingEntity) {
		BuildingDTO buildingDTO = modelMapper.map(buildingEntity, BuildingDTO.class);
		return buildingDTO;
	}

	public BuildingEntity convertToBuildingEntity(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity = modelMapper.map(buildingDTO, BuildingEntity.class);
		return buildingEntity;
	}

}
