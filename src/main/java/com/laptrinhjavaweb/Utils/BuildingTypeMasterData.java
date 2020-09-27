package com.laptrinhjavaweb.Utils;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dto.output.BuildingTypeOutput;
import com.laptrinhjavaweb.dto.output.MasterData;
import com.laptrinhjavaweb.enums.BuildingTypeEnum;

public class BuildingTypeMasterData implements MasterDataUtil {

	@Override
	public List<MasterData> getMasterData() {
		List<MasterData> result = new ArrayList<>();
		for (BuildingTypeEnum enum1 : BuildingTypeEnum.values()) {
			BuildingTypeOutput output = new BuildingTypeOutput();
			output.setCode(enum1.name());
			output.setName(enum1.getValue());
			result.add(output);
		}
		return result;
	}
}
