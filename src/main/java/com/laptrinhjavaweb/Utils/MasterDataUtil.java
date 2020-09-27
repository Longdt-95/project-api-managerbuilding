package com.laptrinhjavaweb.Utils;

import java.util.List;

import com.laptrinhjavaweb.dto.output.MasterData;

public interface MasterDataUtil {

	static MasterDataUtil of(String code) {
		if (code.equalsIgnoreCase("Districts")) {
			return new DistrictsMasterData();
		}
		if (code.equalsIgnoreCase("BuildingType")) {
			return new BuildingTypeMasterData();
		}
		if (code.equalsIgnoreCase("TransactionType")) {
			return new TransactionTypeMasterData();
		}
		return null;
	}

	public List<MasterData> getMasterData();
}
