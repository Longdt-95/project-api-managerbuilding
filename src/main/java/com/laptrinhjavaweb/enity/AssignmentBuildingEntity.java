package com.laptrinhjavaweb.enity;

import java.util.Date;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Table;

@Table (name = "assignmentbuilding")
public class AssignmentBuildingEntity {
	
	@Column (name = "id")
	private long id;
	
	@Column (name = "staffid")
	private long staffId;
	
	@Column (name = "buildingid")
	private long buildingId;
	
	@Column (name = "createdby")
	private String createdBy;
	
	@Column (name = "createddate")
	private Date createdDate;
	
	@Column (name = "modifiedby")
	private String modifiedBy;
	
	@Column (name = "modifieddate")
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
	public long getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(long buildingId) {
		this.buildingId = buildingId;
	}
	
}
