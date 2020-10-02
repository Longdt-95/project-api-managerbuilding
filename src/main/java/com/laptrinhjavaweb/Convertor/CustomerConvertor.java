package com.laptrinhjavaweb.Convertor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.enity.CustomerEntity;

@Component
public class CustomerConvertor {

	ModelMapper modelMapper = new ModelMapper();

	public CustomerDTO convertToCustomerDTO(CustomerEntity customerEntity) {
		CustomerDTO customerDTO = modelMapper.map(customerEntity, CustomerDTO.class);
		return customerDTO;
	}

	public CustomerEntity convertToCustomerEntity(CustomerDTO customerDTO) {
		CustomerEntity customerEntity = modelMapper.map(customerDTO, CustomerEntity.class);
		return customerEntity;
	}
}
