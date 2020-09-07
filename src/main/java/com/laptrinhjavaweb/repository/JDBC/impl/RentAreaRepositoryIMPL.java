package com.laptrinhjavaweb.repository.JDBC.impl;

import java.util.List;

import com.laptrinhjavaweb.enity.RentAreaEntity;
import com.laptrinhjavaweb.repository.JDBC.RentAreaRepository;

public class RentAreaRepositoryIMPL extends SimpleJpaRepositoryIMPL<RentAreaEntity> implements RentAreaRepository{

	@Override
	public List<RentAreaEntity> getRentArea(long id) {
		String sql = "SELECT * FROM rentarea WHERE buildingid = " + id;
		return this.findAll(sql);
	}
}
