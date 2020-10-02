package com.laptrinhjavaweb.repository.JDBC.impl;

import java.util.List;

import com.laptrinhjavaweb.enity.TransactionEntity;
import com.laptrinhjavaweb.repository.JDBC.TransactionRepository;

public class TransactionRepositoryIMPL extends SimpleJpaRepositoryIMPL<TransactionEntity> implements TransactionRepository{

	@Override
	public long saveTransaction(TransactionEntity transactionEntity) {
		return save(transactionEntity);
	}

	@Override
	public List<TransactionEntity> getTransactionByCustomerId(long customerId) {
		String sql = "SELECT * FROM transaction WHERE customerid = " + customerId;
		return findAll(sql);
	}

	

}
