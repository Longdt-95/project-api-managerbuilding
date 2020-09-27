package com.laptrinhjavaweb.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.output.DistrictOutput;

@RestController
public class DistrictsAPI {

	@GetMapping("/district")
	public List<DistrictOutput> getDistricts() {
		return DistrictOutput.getList();
	}
}
