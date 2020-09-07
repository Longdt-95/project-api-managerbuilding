package com.laptrinhjavaweb.Service.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.Convertor.BuildingConvertor;
import com.laptrinhjavaweb.Service.BuildingService;
import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.enity.BuildingEntity;
import com.laptrinhjavaweb.enity.RentAreaEntity;
import com.laptrinhjavaweb.repository.JDBC.BuildingRepository;
import com.laptrinhjavaweb.repository.JDBC.RentAreaRepository;
import com.laptrinhjavaweb.repository.JDBC.impl.BuildingRepositoryIMPL;
import com.laptrinhjavaweb.repository.JDBC.impl.RentAreaRepositoryIMPL;

public class BuildingServiceIMPL implements BuildingService {

	private BuildingRepository buildingRepository = new BuildingRepositoryIMPL();
	private BuildingConvertor buildingConvetor = new BuildingConvertor();
	private RentAreaRepository rentAreaEepository = new RentAreaRepositoryIMPL();

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
			List<RentAreaEntity> result = rentAreaEepository.getRentArea(buildingDTO.getId());
			List<Integer> oldValues = new ArrayList<Integer>();
			List<Integer> newValues = new ArrayList<Integer>();
			List<Integer> valuesDelete = new ArrayList<>();
			List<Integer> valuesInsert = new ArrayList<>();
			for (RentAreaEntity rentAreaEntity : result) {
				oldValues.add(rentAreaEntity.getValue());
			}
			for (String string : buildingDTO.getRentAreas()) {
				newValues.add(Integer.parseInt(string));
			}
			for (Integer newValue : newValues) {
				if (!oldValues.contains(newValue)) {
					valuesInsert.add(newValue);
				}
			}
			for (Integer oldValue : oldValues) {
				if (!newValues.contains(oldValue)) {
					valuesDelete.add(oldValue);
				}
			}
			flag = buildingRepository.updateWithTransaction(buildingEntity, valuesDelete, valuesInsert);
		}else {
			flag = buildingRepository.update(buildingEntity);
		}
		return flag;
	}

}
