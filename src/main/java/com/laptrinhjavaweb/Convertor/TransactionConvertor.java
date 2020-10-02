package com.laptrinhjavaweb.Convertor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.enity.TransactionEntity;

@Component
public class TransactionConvertor {

	ModelMapper modelMapper = new ModelMapper();

	public TransactionDTO convertToTransactionDTO(TransactionEntity transactionEntity) {
		TransactionDTO transactionDTO = modelMapper.map(transactionEntity, TransactionDTO.class);
		return transactionDTO;
	}

	public TransactionEntity convertToTransactionEntity(TransactionDTO transactionDTO) {
		TransactionEntity transactionEntity = modelMapper.map(transactionDTO, TransactionEntity.class);
		return transactionEntity;
	}
}
