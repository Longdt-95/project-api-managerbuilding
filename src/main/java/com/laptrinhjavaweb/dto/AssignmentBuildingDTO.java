package com.laptrinhjavaweb.dto;

public class AssignmentBuildingDTO {
	private long id;
	private long staffId;
	private long buildingId;
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
