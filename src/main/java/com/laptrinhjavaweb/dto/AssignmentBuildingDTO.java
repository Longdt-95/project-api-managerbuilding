package com.laptrinhjavaweb.dto;

public class AssignmentBuildingDTO {

	private Long buildingId;
	private Long staffid;
	private Long[] staffIds;
	private String status;

	public Long getStaffid() {
		return staffid;
	}

	public void setStaffid(Long staffid) {
		this.staffid = staffid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setStaffIds(Long[] staffIds) {
		this.staffIds = staffIds;
	}

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
