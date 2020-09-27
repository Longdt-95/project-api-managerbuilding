package com.laptrinhjavaweb.enums;

public enum TransactionTypeEnum {

	TYPE_1("Qúa trình chăm sóc khách hàng"), TYPE_2("Dẫn đi xem");

	private String typeValue;

	TransactionTypeEnum(String typeValue) {
		this.typeValue = typeValue;
	}

	public String getValue() {
		return this.typeValue;
	}

}
