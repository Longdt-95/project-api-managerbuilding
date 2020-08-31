package com.laptrinhjavaweb.api;

import java.util.EnumMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.Service.impl.BuildingServiceIMPL;
import com.laptrinhjavaweb.constant.DistrictConstant;
import com.laptrinhjavaweb.constant.TypeOfTransactionConstant;

@RestController
public class TypeOfBuildingAPI {

	private BuildingServiceIMPL buildingService = new BuildingServiceIMPL();
	
	// USE CONSTANT
	@GetMapping ("/type-building")
	public List<com.laptrinhjavaweb.constant.TypeOfBuildingConstant> getTypeOfBuilding() {
		return com.laptrinhjavaweb.constant.TypeOfBuildingConstant.getLists();
	}
	
	@GetMapping("/district") 
	public List<DistrictConstant> getdistrict() {
		return DistrictConstant.getLists();
	}
	
	@GetMapping("/type-transaction")
	public List<TypeOfTransactionConstant> getTypeTransaction() {
		return TypeOfTransactionConstant.getLists();
	}
	
	//USE ENUM
	@GetMapping("districts")
	public EnumMap<com.laptrinhjavaweb.enums.DistrictEnum, String> getTypeOfBuilding1() {
		return buildingService.getdistricts();
	}
	
	
}
