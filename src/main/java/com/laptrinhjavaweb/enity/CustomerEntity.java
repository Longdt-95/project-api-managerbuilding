package com.laptrinhjavaweb.enity;

import java.util.Date;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Table;

@Table(name = "customer")
public class CustomerEntity {
	
	@Column(name = "id")
	private long id;

	@Column(name = "fullname")
	private String fullName;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
	
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

	public CustomerEntity() {
		super();
	}

	public CustomerEntity(String fullName, String phone, String email) {
		super();
		this.fullName = fullName;
		this.phone = phone;
		this.email = email;
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
