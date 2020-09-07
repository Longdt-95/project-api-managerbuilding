package com.laptrinhjavaweb.dto;

public class AssignmentBuildingDTO {
	private Long buildingId;
	private Long[] staffIds;
	
	
	public Long getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}
	public Long[] getStaffIds() {
		return staffIds;
	}
	public void setStaffId(Long[] staffId) {
		this.staffIds = staffId;
	}
	
		
}
