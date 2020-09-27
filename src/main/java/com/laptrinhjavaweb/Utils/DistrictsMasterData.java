package com.laptrinhjavaweb.Utils;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dto.output.MasterData;
import com.laptrinhjavaweb.enums.DistrictEnum;

public class DistrictsMasterData implements MasterDataUtil {

	@Override
	public List<MasterData> getMasterData() {
		List<MasterData> result = new ArrayList<>();
		for (DistrictEnum enum1 : DistrictEnum.values()) {
			MasterData output = new MasterData();
			output.setCode(enum1.name());
			output.setName(enum1.getValue());
			result.add(output);
		}
		return result;
	}
}
