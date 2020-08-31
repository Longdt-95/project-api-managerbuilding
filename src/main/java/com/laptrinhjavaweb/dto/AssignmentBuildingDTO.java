package com.laptrinhjavaweb.dto;

import java.util.ArrayList;
import java.util.List;

public class AssignmentBuildingDTO {
	private long id;
	private long staffId;
	private long buildingId;
	private List<Long> staffIdAssignmentBuilding = new ArrayList<>();
	
	public List<Long> getStaffIdAssignmentBuilding() {
		return staffIdAssignmentBuilding;
	}
	public void setStaffIdAssignmentBuilding(List<Long> staffIdAssignmentBuilding) {
		this.staffIdAssignmentBuilding = staffIdAssignmentBuilding;
	}
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
