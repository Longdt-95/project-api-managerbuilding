package com.laptrinhjavaweb.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.Convertor.TransactionConvertor;
import com.laptrinhjavaweb.Service.TransactionService;
import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.enity.TransactionEntity;
import com.laptrinhjavaweb.repository.JDBC.TransactionRepository;
import com.laptrinhjavaweb.repository.JDBC.impl.TransactionRepositoryIMPL;

@Service
public class TransactionServiceIMPL implements TransactionService{
	
	@Autowired
	private TransactionConvertor convertor;
	private TransactionRepository transactionRepo = new TransactionRepositoryIMPL();

	@Override
	public TransactionDTO saveTransaction(TransactionDTO dto) {
		TransactionEntity entity = convertor.convertToTransactionEntity(dto);
		long id = transactionRepo.saveTransaction(entity);
		TransactionDTO transactionDTO = convertor.convertToTransactionDTO(transactionRepo.findById(id));
		return transactionDTO;
	}
	
	

}
