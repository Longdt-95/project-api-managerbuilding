package com.laptrinhjavaweb.repository.JDBC;

import java.util.List;

import com.laptrinhjavaweb.enity.TransactionEntity;

public interface TransactionRepository {

	long saveTransaction(TransactionEntity transactionEntity);

	TransactionEntity findById(long id);

	List<TransactionEntity> getTransactionByCustomerId(long customerId);

}
