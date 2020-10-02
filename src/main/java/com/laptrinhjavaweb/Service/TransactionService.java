package com.laptrinhjavaweb.Service;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.TransactionDTO;

public interface TransactionService {
	
	CustomerDTO saveTransaction(TransactionDTO dto);
}
