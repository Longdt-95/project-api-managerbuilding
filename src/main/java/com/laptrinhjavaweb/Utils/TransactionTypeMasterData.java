package com.laptrinhjavaweb.Utils;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dto.output.MasterData;
import com.laptrinhjavaweb.dto.output.TransactionTypeOutput;
import com.laptrinhjavaweb.enums.TransactionTypeEnum;

public class TransactionTypeMasterData implements MasterDataUtil {

	@Override
	public List<MasterData> getMasterData() {
		List<MasterData> result = new ArrayList<>();
		for (TransactionTypeEnum enum1 : TransactionTypeEnum.values()) {
			TransactionTypeOutput output = new TransactionTypeOutput();
			output.setCode(enum1.name());
			output.setName(enum1.getValue());
			result.add(output);
		}
		return result;
	}

}
