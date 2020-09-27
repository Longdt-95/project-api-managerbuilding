package com.laptrinhjavaweb.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.output.BuildingTypeOutput;

@RestController
public class BuildingTypeAPI {

	@GetMapping("/building-type")
	public List<BuildingTypeOutput> getBuildingType() {
		return BuildingTypeOutput.getList();
	}
}
