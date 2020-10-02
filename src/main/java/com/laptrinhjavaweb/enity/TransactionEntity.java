package com.laptrinhjavaweb.enity;

import java.util.Date;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Table;

@Table(name = "transaction")
public class TransactionEntity {
	
	@Column(name = "id")
	private long id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "customerid")
	private long customerId;
	
	@Column(name = "createdby")
	private String createdBy;

	@Column(name = "createddate")
	private Date createdDate;

	@Column(name = "modifiedby")
	private String modifiedBy;

	@Column(name = "modifieddate")
	private Date modifiedDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
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
