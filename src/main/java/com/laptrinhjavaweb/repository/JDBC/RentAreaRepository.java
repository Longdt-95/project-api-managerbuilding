package com.laptrinhjavaweb.repository.JDBC;

import java.util.List;

import com.laptrinhjavaweb.enity.RentAreaEntity;

public interface RentAreaRepository {

	List<RentAreaEntity> getRentArea(long id);
}
