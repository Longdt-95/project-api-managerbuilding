package com.laptrinhjavaweb.Service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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

@Component
@Service
public class BuildingServiceIMPL implements BuildingService {

	private BuildingRepository buildingRepository = new BuildingRepositoryIMPL();
	private RentAreaRepository rentAreaRepository = new RentAreaRepositoryIMPL();
	@Autowired
	private BuildingConvertor buildingConvertor;

	@Override
	public List<BuildingDTO> getBuildings(BuildingSearchBuilder buildingSearchBuilder) {

		// syntax JAVA 7

		/*
		 * List<BuildingEntity> listBuildingEntitie =
		 * buildingRepository.getBuildings(buildingSearchBuilder); List<BuildingDTO>
		 * listBuildingDTO = new ArrayList<BuildingDTO>(); for (BuildingEntity
		 * buildingEntity : listBuildingEntitie) { BuildingDTO buildingDTO = new
		 * BuildingDTO(); buildingDTO =
		 * buildingConvetor.convertToBuildingDTO(buildingEntity);
		 * listBuildingDTO.add(buildingDTO); } return listBuildingDTO;
		 */

		// syntax JAVA 8

		List<BuildingEntity> listBuildingEntitie = buildingRepository.getBuildings(buildingSearchBuilder);
		List<BuildingDTO> result = listBuildingEntitie.stream()
				.map(item -> buildingConvertor.convertToBuildingDTO(item)).collect(Collectors.toList());
		return result;
	}

	@Override
	public BuildingDTO saveBuilding(BuildingDTO buildingDTO) {
		String[] rentArea = buildingDTO.getRentArea().split(",");
		BuildingEntity buildingEntity = buildingConvertor.convertToBuildingEntity(buildingDTO);
		buildingEntity.setType(convertTypeToString(buildingDTO.getTypes()));
		long id = buildingRepository.saveWithTransaction(buildingEntity, rentArea);
		BuildingDTO buildingDTOResult = buildingConvertor.convertToBuildingDTO(buildingRepository.findById(id));
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
		BuildingEntity buildingEntity = buildingConvertor.convertToBuildingEntity(buildingDTO);
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
			flag = buildingRepository.updateWithTransaction(buildingEntity, rentArea);
		} else {
			flag = buildingRepository.update(buildingEntity);
		}
		return flag;
	}

	@Override
	public boolean delBuilding(long buildingId) {
		return buildingRepository.deleteWithTransaction(buildingId);
	}

	@Override
	public BuildingDTO getBuilding(long id) {
		BuildingDTO buildingDTO = new BuildingDTO();
		List<RentAreaEntity> rentAreaEntities = new ArrayList<>();
		buildingDTO = buildingConvertor.convertToBuildingDTO(buildingRepository.findById(id));
		rentAreaEntities = rentAreaRepository.getRentArea(id);
		String rentArea = rentAreaEntities.stream().map(item -> item.getValue().toString())
				.collect(Collectors.joining(","));
		buildingDTO.setRentArea(rentArea);
		return buildingDTO;
	}

	@Override
	public List<BuildingDTO> getListBuildingByStaffId(long staffId) {
		List<BuildingDTO> buildingDTOs = new ArrayList<>();
		List<BuildingEntity> listBuildingEntitie = buildingRepository.findAllBuildingsByStaffId(staffId);
		buildingDTOs = listBuildingEntitie.stream().map(item -> buildingConvertor.convertToBuildingDTO(item))
				.collect(Collectors.toList());
		for (int i = 0; i < buildingDTOs.size(); i++) {
			List<RentAreaEntity> areaEntities = new ArrayList<>();
			areaEntities = rentAreaRepository.getRentArea(listBuildingEntitie.get(i).getId());
			String rentArea = areaEntities.stream().map(item -> item.getValue().toString())
					.collect(Collectors.joining(","));
			buildingDTOs.get(i).setRentArea(rentArea);
		}
		return buildingDTOs;
	}

	@Override
	public List<BuildingDTO> getBuildingsPrioritize(long staffId, String prioritize) {
		List<BuildingEntity> buildingEntities = buildingRepository.getBuildingsPrioritize(staffId, prioritize);
		List<BuildingDTO> buildingDTOs = buildingEntities.stream()
				.map(item -> buildingConvertor.convertToBuildingDTO(item)).collect(Collectors.toList());
		for (int i = 0; i < buildingDTOs.size(); i++) {
			List<RentAreaEntity> areaEntities = new ArrayList<>();
			areaEntities = rentAreaRepository.getRentArea(buildingEntities.get(i).getId());
			String rentArea = areaEntities.stream().map(item -> item.getValue().toString())
					.collect(Collectors.joining(","));
			buildingDTOs.get(i).setRentArea(rentArea);
		}
		return buildingDTOs;
	}

}
