package com.laptrinhjavaweb.Service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.Convertor.CustomerConvertor;
import com.laptrinhjavaweb.Convertor.TransactionConvertor;
import com.laptrinhjavaweb.Service.CustomerService;
import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.dto.AssignmentCustomerDTO;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.enity.CustomerEntity;
import com.laptrinhjavaweb.enity.TransactionEntity;
import com.laptrinhjavaweb.enums.TransactionTypeEnum;
import com.laptrinhjavaweb.repository.JDBC.AssignmentCustomerRepository;
import com.laptrinhjavaweb.repository.JDBC.CustomerRepository;
import com.laptrinhjavaweb.repository.JDBC.TransactionRepository;
import com.laptrinhjavaweb.repository.JDBC.impl.AssignmentCustomerRepositoryIMPL;
import com.laptrinhjavaweb.repository.JDBC.impl.CustomerRepositoryIMPL;
import com.laptrinhjavaweb.repository.JDBC.impl.TransactionRepositoryIMPL;

@Service
public class CustomerServiceIMPL implements CustomerService {

	@Autowired
	private CustomerConvertor convertor;
	@Autowired
	private TransactionConvertor transactionConvertor;
	private CustomerRepository customerRepo = new CustomerRepositoryIMPL();
	private TransactionRepository transactionRepo = new TransactionRepositoryIMPL();
	private AssignmentCustomerRepository assignmentCustomerRepo = new AssignmentCustomerRepositoryIMPL();

	@Override
	public List<CustomerDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerDTO> getAll(long userId, String code) {
		List<CustomerEntity> customerEntities = customerRepo.getAll(userId, code);
		List<CustomerDTO> result = customerEntities.stream().map(item -> convertor.convertToCustomerDTO(item))
				.collect(Collectors.toList());
		return result;
	}

	@Override
	public List<CustomerDTO> getCustomersSearch(Map<String, String> requestParam) {
		CustomerSearchBuilder customerSearchBuilder = convertMaptoCustomerEntity(requestParam);
		List<CustomerEntity> entities = customerRepo.getCustomersSearch(customerSearchBuilder);
		List<CustomerDTO> result = entities.stream().map(item -> convertor.convertToCustomerDTO(item))
				.collect(Collectors.toList());
		return result;
	}

	private CustomerSearchBuilder convertMaptoCustomerEntity(Map<String, String> requestParam) {
		CustomerSearchBuilder customerSearchBuilder = new CustomerSearchBuilder.BuilderCustomer()
				.setFullName(requestParam.containsKey("name") ? requestParam.get("name") : null)
				.setPhone(requestParam.containsKey("phone") ? requestParam.get("phone") : null)
				.setEmail(requestParam.containsKey("email") ? requestParam.get("email") : null)
				.setStaffId(requestParam.containsKey("staffId") ? requestParam.get("staffId") : null).build();
		return customerSearchBuilder;
	}

	@Override
	public CustomerDTO saveCustomer(CustomerDTO dto) {
		CustomerEntity customerEntity = convertor.convertToCustomerEntity(dto);
		long idCustomer = customerRepo.saveCustomer(customerEntity);
		CustomerDTO customerDTO = convertor.convertToCustomerDTO(customerRepo.findById(idCustomer));
		return customerDTO;
	}

	@Override
	public boolean updateCustomer(CustomerDTO customerDTO) {
		CustomerEntity customerEntity = convertor.convertToCustomerEntity(customerDTO);
		return customerRepo.updateCustomer(customerEntity);
	}

	@Override
	public boolean delCustomer(long[] customerIds) {
		boolean flag = false;
		for (long longId : customerIds) {
			flag = customerRepo.delWithTransaction(longId);
		}
		return flag;
	}

	@Override
	public CustomerDTO getCustomerById(long customerId) {
		CustomerDTO customerDTO = convertor.convertToCustomerDTO(customerRepo.findById(customerId));
		List<TransactionEntity> transactionEntities = transactionRepo.getTransactionByCustomerId(customerId);
		List<TransactionDTO> result = transactionEntities.stream()
				.map(item -> transactionConvertor.convertToTransactionDTO(item)).collect(Collectors.toList());
		customerDTO.setListResult(result);
		for (TransactionDTO transactionDTO: customerDTO.getListResult()) {
			if (transactionDTO.getCode().equals(TransactionTypeEnum.TYPE_1.name())) {
				transactionDTO.setCode(TransactionTypeEnum.TYPE_1.getValue());
			}else if (transactionDTO.getCode().equals(TransactionTypeEnum.TYPE_2.name())) {
				transactionDTO.setCode(TransactionTypeEnum.TYPE_2.getValue());
			}
		}
		return customerDTO;
	}

	@Override
	public boolean updateAssign(AssignmentCustomerDTO assignmentcustomer) {
		if (assignmentcustomer.getStaffIds() != null) {
			List<Long> newUserds = getNewStaffIds(assignmentcustomer.getStaffIds());
			List<Long> oldUserIds = assignmentCustomerRepo.getStaffIds(assignmentcustomer.getCustomerId());
			List<Long> isCheckedUsers = new ArrayList<>();
			List<Long> unCheckedUsers = new ArrayList<>();
			boolean flag = false;
			for (Long newUserd : newUserds) {
				if (!oldUserIds.contains(newUserd)) {
					isCheckedUsers.add(newUserd);
				}
			}
			for (Long oldUserId : oldUserIds) {
				if (!newUserds.contains(oldUserId)) {
					unCheckedUsers.add(oldUserId);
				}
			}
			flag = assignmentCustomerRepo.assignCustomer(isCheckedUsers, unCheckedUsers,
					assignmentcustomer.getCustomerId());
			return flag;
		}
		return true;
	}

	private List<Long> getNewStaffIds(Long[] staffId) {
		List<Long> result = new ArrayList<Long>();
		for (Long long1 : staffId) {
			result.add(long1);
		}
		return result;
	}

}
