package com.laptrinhjavaweb.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.Convertor.TransactionConvertor;
import com.laptrinhjavaweb.Service.TransactionService;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.enity.TransactionEntity;
import com.laptrinhjavaweb.repository.JDBC.TransactionRepository;
import com.laptrinhjavaweb.repository.JDBC.impl.TransactionRepositoryIMPL;

@Service
public class TransactionServiceIMPL implements TransactionService{
	
	@Autowired
	private TransactionConvertor TransactionConvertor;
	@Autowired
	private CustomerServiceIMPL customerServiceIMPL;
	private TransactionRepository transactionRepo = new TransactionRepositoryIMPL();

	@Override
	public CustomerDTO saveTransaction(TransactionDTO dto) {
		TransactionEntity entity = TransactionConvertor.convertToTransactionEntity(dto);
		transactionRepo.saveTransaction(entity);
		CustomerDTO customerDTO = customerServiceIMPL.getCustomerById(dto.getCustomerId());
		return customerDTO;
	}
	
	

}
