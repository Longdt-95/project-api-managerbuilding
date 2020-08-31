package com.laptrinhjavaweb.enums;

public enum TypeOfBuildingEnum {
	TANG_TRET ("Tầng trệt"),
	NGUYEN_CAN ("Nguyên Căn"),
	NOI_THAT ("Nội thất");
	
	private String typeValue;
	TypeOfBuildingEnum(String typeValue) {
		this.typeValue = typeValue;
	}
	public String getValue() {
		return this.typeValue;
	}

}
