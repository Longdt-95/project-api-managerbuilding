package com.laptrinhjavaweb.Convertor;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.modelmapper.ModelMapper;

public class GenericConvertor<T1, T2> {

	private Class<T1> getDTOClass() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) t;
		@SuppressWarnings("unchecked")
		Class<T1> zClass = (Class<T1>) parameterizedType.getActualTypeArguments()[0];
		return zClass;
	}

	private Class<T2> getEntityClass() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) t;
		@SuppressWarnings("unchecked")
		Class<T2> zClass = (Class<T2>) parameterizedType.getActualTypeArguments()[1];
		return zClass;
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	public <T1> T1 convertorToDTO(T2 t2) {
		return (T1) new ModelMapper().map(t2, getDTOClass());
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	public <T2> T2 convertorToEntity(T1 t1) {
		return (T2) new ModelMapper().map(t1, getEntityClass());
	}
}
