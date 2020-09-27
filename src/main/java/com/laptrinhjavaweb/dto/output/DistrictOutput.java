package com.laptrinhjavaweb.dto.output;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.enums.DistrictEnum;

public class DistrictOutput extends MasterData {

	public static List<DistrictOutput> getList() {
		List<DistrictOutput> result = new ArrayList<>();
		for (DistrictEnum enum1 : DistrictEnum.values()) {
			DistrictOutput output = new DistrictOutput();
			output.setCode(enum1.name());
			output.setName(enum1.getValue());
			result.add(output);
		}
		return result;
	}
}
