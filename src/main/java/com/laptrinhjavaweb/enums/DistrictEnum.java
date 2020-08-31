package com.laptrinhjavaweb.enums;

public enum DistrictEnum {
	QUAN_1 ("Quận 1"),
	QUAN_2 ("Quận 2"),
	QUAN_3 ("Quận 3"),
	QUAN_4 ("Quận 4");
	
	private String districtCode;
	DistrictEnum(String districtCode) {
		this.districtCode = districtCode;
	}
	public String getValue() {
		return this.districtCode;
	}

	
}
