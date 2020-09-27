package com.laptrinhjavaweb.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.output.TransactionTypeOutput;

@RestController
public class TransactionTypeAPI {

	@GetMapping("/TransactionType")
	public List<TransactionTypeOutput> getTransactionTypes() {
		return TransactionTypeOutput.getList();
	}
}
