package com.laptrinhjavaweb.enums;

public enum TypeOfTransactionEnum {
	TYPE_1 ("Qúa trình chăm sóc khách hàng"),
	TYPE_2 ("Dẫn đi xem");
	
	private String typeValue;
	TypeOfTransactionEnum(String typeValue) {
		this.typeValue = typeValue;
	}
	public String getValue() {
		return this.typeValue;
	}

}
