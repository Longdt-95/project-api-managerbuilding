package com.laptrinhjavaweb.enity;

import java.util.Date;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Table;

@Table(name = "assignmentcustomer")
public class AssignmentCustomerEntity {
	
	@Column(name = "id")
	private long id;
	
	@Column(name = "staffid")
	private long staffId;
	
	@Column(name = "customerid")
	private long customerId;
	
	@Column(name = "createby")
	private String createdBy;
	
	@Column(name = "createdate")
	private Date createdDate;
	
	@Column(name = "modefiedby")
	private String modifiedBy;
	
	@Column(name = "modefieddate")
	private Date modifiedDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getStaffId() {
		return staffId;
	}
	public void setStaffId(long staffId) {
		this.staffId = staffId;
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
