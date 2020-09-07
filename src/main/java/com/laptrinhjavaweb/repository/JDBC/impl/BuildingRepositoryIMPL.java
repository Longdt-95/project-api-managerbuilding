package com.laptrinhjavaweb.repository.JDBC.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.enity.BuildingEntity;
import com.laptrinhjavaweb.repository.JDBC.BuildingRepository;

public class BuildingRepositoryIMPL extends SimpleJpaRepositoryIMPL<BuildingEntity> implements BuildingRepository {

	@Override
	public List<BuildingEntity> getBuildings(BuildingSearchBuilder buildingSearchBuilder) {
		StringBuilder sql = new StringBuilder("SELECT * FROM building b");
		if (buildingSearchBuilder.getstaffId() != null) {
			sql.append(" JOIN assignmentbuilding a on b.id = a.buildingid");
		}
		sql.append(" WHERE 1 = 1");
		sql = buildSQLBuildingSearchCommon(buildingSearchBuilder, sql);
		sql = buildSQLBuiSearchSpecial(buildingSearchBuilder, sql);
		if (buildingSearchBuilder.getstaffId() != null) {
			sql.append(" AND a.staffid = " + buildingSearchBuilder.getstaffId());
		}
		return this.findAll(sql.toString());
	}

	private StringBuilder buildSQLBuiSearchSpecial(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
		if (buildingSearchBuilder.getRentPriceFrom() != null) {
			sql.append(" AND b.rentprice >= " + buildingSearchBuilder.getRentPriceFrom());
		} 
		if (buildingSearchBuilder.getRentPriceTo() != null) {
			sql.append(" AND b.rentprice <= " + buildingSearchBuilder.getRentPriceTo());
		}
		if (buildingSearchBuilder.getRentAreaFrom() != null || buildingSearchBuilder.getRentAreaTo() != null) {
			sql.append(" AND EXISTS (SELECT * FROM rentarea r WHERE r.buildingid = b.id");
			if (buildingSearchBuilder.getRentAreaFrom() != null) {
				sql.append(" AND r.value >= " + buildingSearchBuilder.getRentAreaFrom());
			}
			if (buildingSearchBuilder.getRentAreaTo() != null) {
				sql.append(" AND r.value <= " + buildingSearchBuilder.getRentAreaTo());
			}
			sql.append(" )");
		}
		if (buildingSearchBuilder.getTypes() != null) {
			int lengthType = buildingSearchBuilder.getTypes().length;
			sql.append(" and (b.type like '%" + buildingSearchBuilder.getTypes()[0] + "%'");
			for (int i = 1; i < lengthType; i++) {
				if (i >= 1) {
					sql.append(" or b.type like '%" + buildingSearchBuilder.getTypes()[i] + "%'");
				}
			}
			sql.append(")");
		}

		return sql;
	}

	private StringBuilder buildSQLBuildingSearchCommon(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
		Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
		try {
			for (Field field : fields) {
				field.setAccessible(true);
				if (!field.getName().startsWith("rentPrice") && !field.getName().startsWith("rentArea")
						&& !field.getName().equals("types") && !field.getName().equals("staffId")) {
					if (field.getType().getName().equals("java.lang.String")) {
						if (field.get(buildingSearchBuilder) != null) {
							sql.append(" and b." + field.getName().toLowerCase() + " like '%"
									+ field.get(buildingSearchBuilder) + "%'");
						}
					} else if (field.getType().getName().equals("java.lang.Integer")) {
						if (field.get(buildingSearchBuilder) != null) {
							sql.append(" and b." + field.getName().toLowerCase() + " = "
									+ field.get(buildingSearchBuilder));
						}
					}
				}
			}
			return sql;
		} catch (IllegalArgumentException | IllegalAccessException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	@SuppressWarnings({ "unused", "static-access" })
	public long saveWithTransaction(BuildingDTO buildingDTO) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		long buildingId = -1;
		try {
			connection = SingletonConnection.getInstance().getConnection();
			connection.setAutoCommit(false);
			String sqlInsertBuilding = buildSQLInsertBuilding(buildingDTO);
			statement = connection.prepareStatement(sqlInsertBuilding, statement.RETURN_GENERATED_KEYS);
			setParameter(statement, buildingDTO);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			while (resultSet.next()) {
				buildingId = resultSet.getLong(1);
			}
			String sqlInsertBuildingRentArea = "INSERT INTO rentarea(value, buildingid) values (?,?)";
			statement = connection.prepareStatement(sqlInsertBuildingRentArea, statement.RETURN_GENERATED_KEYS);
			for (String string : buildingDTO.getRentAreas()) {
				statement.setInt(1, Integer.parseInt(string));
				statement.setLong(2, buildingId);
				statement.executeUpdate();
			}
			connection.commit();
			return buildingId;
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println(e.getMessage());
			return buildingId;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return buildingId;
			}
		}

	}

	// buildSQLQuery insertBuilding
	private String buildSQLInsertBuilding(BuildingDTO buildingDTO) {
		Field[] fields = BuildingDTO.class.getDeclaredFields();
		StringBuilder name = new StringBuilder();
		StringBuilder parameter = new StringBuilder();
		String sql;
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			try {
				if (i >= 1 && !fields[i].getName().equals("rentArea") && !fields[i].getName().equals("rentAreas")) {
					name.append(fields[i].getName().toLowerCase() + ",");
					parameter.append("?,");
				}
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		name.deleteCharAt(name.toString().length() - 1);
		parameter.deleteCharAt(parameter.toString().length() - 1);
		sql = "INSERT INTO building (" + name.toString() + ") values (" + parameter.toString() + ")";
		return sql;
	}

	// convert Type from array to String
	private String convertTypeToString(String[] type) {
		StringBuilder stringBuilder = new StringBuilder();
		for (String string : type) {
			stringBuilder.append(string + ",");
		}
		String types = stringBuilder.toString();
		return types.substring(0, types.length() - 1);
	}

	// set param for sql insertBuilding
	private void setParameter(PreparedStatement statement, BuildingDTO buildingDTO) {
		Field[] fields = BuildingDTO.class.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			try {
				int index = 1;
				for (Field field : buildingDTO.getClass().getDeclaredFields()) {
					field.setAccessible(true);
					if (!field.getName().equals("id") && !field.getName().equals("rentArea")
							&& !field.getName().equals("rentAreas") && !field.getName().equals("type")) {
						statement.setObject(index, field.get(buildingDTO));
						index++;
					} else if (field.getName().equals("type")) {
						String type = convertTypeToString(buildingDTO.getTypes());
						statement.setObject(index, type);
						index++;
					}
				}
			} catch (IllegalArgumentException | IllegalAccessException | SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@SuppressWarnings("resource")
	@Override
	public boolean updateWithTransaction(BuildingEntity buildingEntity, List<Integer> valuesDelete, List<Integer> valuesInsert) {
		Connection connection = null;
		PreparedStatement statement = null;
		boolean flag = false;
		try {
			connection = SingletonConnection.getInstance().getConnection();
			connection.setAutoCommit(false);
			String sqlUpdateBuilding = this.buildSqlUpdate();
			statement = connection.prepareStatement(sqlUpdateBuilding);
			Field[] fields = buildingEntity.getClass().getDeclaredFields();
			int index = 1;
			Object t = null;
			for (Field field : fields) {
				field.setAccessible(true);
				if (!field.getName().equals("id")) {
					statement.setObject(index, field.get(buildingEntity));
					index++;
				} else
					t = field.get(buildingEntity);
			}
			statement.setObject(index, t);
			statement.execute();
			// save RentArea
			String sqlDeleteRentArea = "DELETE FROM rentarea WHERE value = ? AND buildingid = ?";
			statement = connection.prepareStatement(sqlDeleteRentArea);
			for (Integer value : valuesDelete) {
				statement.setInt(1, value);
				statement.setLong(2, buildingEntity.getId());
				statement.execute();
			}
			String sqlInsertRentArea = "INSERT INTO rentarea(value,buildingid) VALUES(?,?)";
			statement = connection.prepareStatement(sqlInsertRentArea);
			for (Integer value : valuesInsert) {
				statement.setInt(1, value);
				statement.setLong(2, buildingEntity.getId());
				statement.execute();
			}
			connection.commit();
			flag = true;
			return flag;
		} catch (SQLException | IllegalAccessException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println(e.getMessage());
			return flag;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return flag;
			}
		}
	}

	@SuppressWarnings("resource")
	@Override
	public boolean deleteWithTransaction(long id) {
		Connection connection = null;
		PreparedStatement statement = null;
		boolean flag = false;
		try {
			connection = SingletonConnection.getInstance().getConnection();
			connection.setAutoCommit(false);
			String sqlDelFromAssign = "DELETE FROM assignmentbuilding WHERE buildingid = ?";
			statement = connection.prepareStatement(sqlDelFromAssign);
			statement.setLong(1, id);
			statement.execute();
			String sqlDelFromRentarea = "DELETE FROM rentarea WHERE buildingid = ?";
			statement = connection.prepareStatement(sqlDelFromRentarea);
			statement.setLong(1, id);
			statement.execute();
			String sqlDelBuilding = "DELETE FROM building WHERE id = ?";
			statement = connection.prepareStatement(sqlDelBuilding);
			statement.setLong(1, id);
			statement.execute();
			connection.commit();
			flag = true;
			return flag;
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println(e.getMessage());
			return flag;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return flag;
			}
		}
	}


	

}
