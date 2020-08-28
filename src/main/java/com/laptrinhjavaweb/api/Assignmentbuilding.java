package com.laptrinhjavaweb.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.Service.AssignmentBuildingService;
import com.laptrinhjavaweb.Service.impl.AssignmentBuildingServiceIMPL;
import com.laptrinhjavaweb.dto.AssignmentBuildingDTO;

@RestController
public class Assignmentbuilding {
	
	private AssignmentBuildingService assignmentBuildingService = new AssignmentBuildingServiceIMPL();
	
	@PostMapping ("/manager-building")
	public long addManagerBuilding(@RequestBody AssignmentBuildingDTO assignmentBuildingDTO) {
		return assignmentBuildingService.addAssignmentBuilding(assignmentBuildingDTO);
	}
}
