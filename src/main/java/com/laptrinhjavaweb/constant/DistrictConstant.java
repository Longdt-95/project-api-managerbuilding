package com.laptrinhjavaweb.constant;

import java.util.ArrayList;
import java.util.List;

public class DistrictConstant {
	private String code;
	private String name;
	
	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	private DistrictConstant(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public static final DistrictConstant district = new DistrictConstant("QUAN_1", "Quận 1");
	public static final DistrictConstant district2 = new DistrictConstant("QUAN_2", "Quận 2");
	public static final DistrictConstant district3 = new DistrictConstant("QUAN_3", "Quận 3");
	public static final DistrictConstant district4 = new DistrictConstant("QUAN_4", "Quận 4");
			
	public static List<DistrictConstant> getLists() {
		List<DistrictConstant> listType = new ArrayList<>();
		listType.add(district);
		listType.add(district2);
		listType.add(district3);
		listType.add(district4);
		return listType;
	}
	
}
