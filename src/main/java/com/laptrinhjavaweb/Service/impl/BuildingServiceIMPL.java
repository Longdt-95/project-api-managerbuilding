package com.laptrinhjavaweb.Service.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.Convertor.BuildingConvertor;
import com.laptrinhjavaweb.Service.BuildingService;
import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.enity.BuildingEntity;
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
		String[] rentArea = buildingDTO.getRentArea().split(",");
		BuildingEntity buildingEntity = buildingConvetor.convertToBuildingEntity(buildingDTO);
		buildingEntity.setType(convertTypeToString(buildingDTO.getTypes()));
		long id = buildingRepository.saveWithTransaction(buildingEntity, rentArea);
		BuildingDTO buildingDTOResult = buildingConvetor.convertToBuildingDTO(buildingRepository.findById(id));
		return buildingDTOResult;
	}
	
	private String convertTypeToString(String[] type) {
		StringBuilder stringBuilder = new StringBuilder();
		for (String string : type) {
			stringBuilder.append(string + ",");
		}
		String types = stringBuilder.toString();
		return types.substring(0, types.length() - 1);
	}

	@Override
	public boolean updateBuilding(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity = buildingConvetor.convertToBuildingEntity(buildingDTO);
		StringBuilder type = new StringBuilder();
		for (String string : buildingDTO.getTypes()) {
			type.append(string + ",");
		}
		type.deleteCharAt(type.length() - 1);
		buildingEntity.setType(type.toString());
		boolean flag = false;
		if (buildingDTO.getRentAreas() != null) {
			List<Integer> rentArea = new ArrayList<Integer>();
			for (String string : buildingDTO.getRentAreas()) {
				rentArea.add(Integer.parseInt(string));
			}
			flag = buildingRepository.updateWithTransaction(buildingEntity,rentArea);
		}else {
			flag = buildingRepository.update(buildingEntity);
		}
		return flag;
	}

	@Override
	public boolean delBuilding(long buildingId) {
		return buildingRepository.deleteWithTransaction(buildingId);
	}

}
