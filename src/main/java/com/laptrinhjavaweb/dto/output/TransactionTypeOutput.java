package com.laptrinhjavaweb.dto.output;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.enums.TransactionTypeEnum;

public class TransactionTypeOutput extends MasterData {
	public static List<TransactionTypeOutput> getList() {
		List<TransactionTypeOutput> result = new ArrayList<>();
		for (TransactionTypeEnum enum1 : TransactionTypeEnum.values()) {
			TransactionTypeOutput output = new TransactionTypeOutput();
			output.setCode(enum1.name());
			output.setName(enum1.getValue());
			result.add(output);
		}
		return result;
	}
	
}
