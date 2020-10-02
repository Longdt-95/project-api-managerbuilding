package com.laptrinhjavaweb.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerDTO {

	private long id;
	private String fullName;
	private String phone;
	private String email;
	private List<TransactionDTO> listResult = new ArrayList<>();
	private String createdBy;
	private Date createdDate;
	private String modifiedBy;
	private Date modifiedDate;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<TransactionDTO> getListResult() {
		return listResult;
	}

	public void setListResult(List<TransactionDTO> listResult) {
		this.listResult = listResult;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
