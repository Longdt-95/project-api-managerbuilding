package com.laptrinhjavaweb.enity;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Table;

@Table(name = "role")
public class RoleEntity {

	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
