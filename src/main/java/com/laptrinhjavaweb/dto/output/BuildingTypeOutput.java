package com.laptrinhjavaweb.dto.output;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.enums.BuildingTypeEnum;

public class BuildingTypeOutput extends MasterData {

	public static List<BuildingTypeOutput> getList() {
		List<BuildingTypeOutput> result = new ArrayList<>();
		for (BuildingTypeEnum enum1 : BuildingTypeEnum.values()) {
			BuildingTypeOutput output = new BuildingTypeOutput();
			output.setCode(enum1.name());
			output.setName(enum1.getValue());
			result.add(output);
		}
		return result;
	}
}
