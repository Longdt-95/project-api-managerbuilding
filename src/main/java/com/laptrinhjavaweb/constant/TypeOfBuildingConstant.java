package com.laptrinhjavaweb.constant;

import java.util.ArrayList;
import java.util.List;

public class TypeOfBuildingConstant {
	private String code;
	private String name;
	
	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	private TypeOfBuildingConstant(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public static final TypeOfBuildingConstant tang_tret = new TypeOfBuildingConstant("TANG_TRET", "Tầng trệt");
	public static final TypeOfBuildingConstant nguyen_can = new TypeOfBuildingConstant("NGUYEN_CAN", "Nguyên căn");
	public static final TypeOfBuildingConstant noi_that = new TypeOfBuildingConstant("NOI_THAT", "Nội thất");
	
			
	public static List<TypeOfBuildingConstant> getLists() {
		List<TypeOfBuildingConstant> listType = new ArrayList<>();
		listType.add(tang_tret);
		listType.add(nguyen_can);
		listType.add(noi_that);
		return listType;
	}
}
