package com.laptrinhjavaweb.constant;

import java.util.ArrayList;
import java.util.List;

public class TypeOfTransactionConstant {
	private String code;
	private String name;
	
	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	private TypeOfTransactionConstant(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public static final TypeOfTransactionConstant type_1 = new TypeOfTransactionConstant("TYPE_1", "Quá trình chăm sóc khách hàng");
	public static final TypeOfTransactionConstant type_2 = new TypeOfTransactionConstant("TYPE_2", "dẫn đi xem");
			
	public static List<TypeOfTransactionConstant> getLists() {
		List<TypeOfTransactionConstant> listType = new ArrayList<>();
		listType.add(type_1);
		listType.add(type_2);
		return listType;
	}
}
