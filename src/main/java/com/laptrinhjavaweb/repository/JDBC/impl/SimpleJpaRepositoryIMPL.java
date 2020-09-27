package com.laptrinhjavaweb.repository.JDBC.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.laptrinhjavaweb.Mapper.ObjectMapper;
import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Table;
import com.laptrinhjavaweb.repository.JDBC.SimpleJpaRepository;

public class SimpleJpaRepositoryIMPL<T> implements SimpleJpaRepository<T> {

	ObjectMapper<T> objectMapper = new ObjectMapper<T>();

	private Class<T> getZClass() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) t;
		@SuppressWarnings("unchecked")
		Class<T> zClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
		return zClass;
	}

	@SuppressWarnings("static-access")
	@Override
	public long save(T t) {
		String sql = buildSqlInsert();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		long id = -1;
		try {
			connection = SingletonConnection.getInstance().getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, statement.RETURN_GENERATED_KEYS);
			int index = 1;
			for (Field field : t.getClass().getDeclaredFields()) {
				field.setAccessible(true);
				if (!field.getName().equals("id")) {
					statement.setObject(index, field.get(t));
					index++;
				}
			}
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			while (resultSet.next()) {
				id = resultSet.getLong(1);
			}
			connection.commit();
			return id;
		} catch (SQLException | IllegalAccessException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println(e.getMessage());
			return id;
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
			}
		}

	}

	private String buildSqlInsert() {
		Class<T> zClass = getZClass();
		String tableName = "";
		if (zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		Field[] fields = zClass.getDeclaredFields();
		StringBuilder name = new StringBuilder();
		StringBuilder parameter = new StringBuilder();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Column.class)) {
				if (!field.getName().equals("id")) {
					Column column = field.getAnnotation(Column.class);
					name.append(column.name() + ",");
					parameter.append("?,");
				}
			}
		}
		name.deleteCharAt(name.toString().length() - 1);
		parameter.deleteCharAt(parameter.toString().length() - 1);
		String sql = "INSERT INTO " + tableName + "(" + name.toString() + ") values (" + parameter.toString() + ")";
		return sql;
	}

	@Override
	public T findById(long id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = SingletonConnection.getInstance().getConnection();
			Class<T> zClass = getZClass();
			String tableName = "";
			if (zClass.isAnnotationPresent(Table.class)) {
				Table table = zClass.getAnnotation(Table.class);
				tableName = table.name();
			}
			String sql = "select * from " + tableName + " where id = ?";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			List<T> result = objectMapper.maprow(resultSet, zClass);
			return result != null ? result.get(0) : null;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
			}
		}
		return null;
	}

	@Override
	public List<T> findAll() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = SingletonConnection.getInstance().getConnection();
			Class<T> zClass = getZClass();
			String tableName = "";
			if (zClass.isAnnotationPresent(Table.class)) {
				Table table = zClass.getAnnotation(Table.class);
				tableName = table.name();
			}
			String sql = "select * from " + tableName;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			return objectMapper.maprow(resultSet, zClass);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
			}
		}
		return null;
	}

	@Override
	public boolean update(Object object) {
		String sql = buildSqlUpdate();
		Connection connection = null;
		PreparedStatement statement = null;
		boolean flag = false;
		try {
			connection = SingletonConnection.getInstance().getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			Field[] fields = object.getClass().getDeclaredFields();
			int index = 1;
			Object t = null;
			for (Field field : fields) {
				field.setAccessible(true);
				if (!field.getName().equals("id")) {
					statement.setObject(index, field.get(object));
					index++;
				} else
					t = field.get(object);
			}
			statement.setObject(index, t);
			flag = statement.execute();
			connection.commit();
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
			}
		}
	}

	protected String buildSqlUpdate() {
		Class<T> zClass = getZClass();
		String tableName = "";
		if (zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		Field[] fields = zClass.getDeclaredFields();
		StringBuilder columnAndValue = new StringBuilder("");
		for (int i = 0; i < fields.length; i++) {
			if (!fields[i].getName().equals("id") && fields[i].isAnnotationPresent(Column.class)) {
				if (i > 1) {
					columnAndValue.append(",");
				}
				Column column = fields[i].getAnnotation(Column.class);
				columnAndValue.append(column.name() + " = ? ");
			}
		}
		columnAndValue.deleteCharAt(columnAndValue.length() - 1);
		String sql = "UPDATE " + tableName + " SET " + columnAndValue + " WHERE id = ?";
		return sql;
	}

	@Override
	public int delete(long id) {
		Connection connection = null;
		PreparedStatement statement = null;
		Class<T> zClass = getZClass();
		String tableName = "";
		int result = -1;
		if (zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		String sql = "DELETE FROM " + tableName + " WHERE ID = ?";
		try {
			connection = SingletonConnection.getInstance().getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			statement.setObject(1, id);
			result = statement.executeUpdate();
			connection.commit();
			return result;
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println(e.getMessage());
			return result;
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
			}
		}
	}

	@Override
	public List<T> findAll(String sql) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = SingletonConnection.getInstance().getConnection();
			Class<T> zClass = getZClass();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			return objectMapper.maprow(resultSet, zClass);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
			}
		}
		return null;
	}

	@Override
	public int delete(String sql) {
		Connection connection = null;
		PreparedStatement statement = null;
		int result = -1;
		try {
			connection = SingletonConnection.getInstance().getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			result = statement.executeUpdate();
			connection.commit();
			return result;
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println(e.getMessage());
			return result;
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
			}
		}
	}

}
