
package com.laptrinhjavaweb.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.Service.AssignmentBuildingService;
import com.laptrinhjavaweb.Service.BuildingService;
import com.laptrinhjavaweb.Service.UserService;
import com.laptrinhjavaweb.Service.impl.AssignmentBuildingServiceIMPL;
import com.laptrinhjavaweb.Service.impl.BuildingServiceIMPL;
import com.laptrinhjavaweb.Service.impl.UserServiceIMPL;
import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.AssignmentBuildingDTO;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.UserDTO;

@RestController
public class BuildingAPI {

	private BuildingService buildingService = new BuildingServiceIMPL();
	private AssignmentBuildingService assignmentBuildingService = new AssignmentBuildingServiceIMPL();
	private UserService userService = new UserServiceIMPL();

	@GetMapping("/buildings")
	public List<BuildingDTO> getBuildingsSearch(@RequestParam Map<String, String> requestParams,
			@RequestParam String[] type) {
		BuildingSearchBuilder buildingSearchBuilder = convertMapToBuilder(requestParams, type);
		return buildingService.getBuildings(buildingSearchBuilder);
	}
	
	@GetMapping("/buildings/assignment")
	public List<BuildingDTO> getBuildingsByStaffId(@RequestParam long staffId) {
		List<BuildingDTO> buildingDTOs = new ArrayList<>();
		buildingDTOs = buildingService.getListBuildingByStaffId(staffId);
		return buildingDTOs;
	}
	
	@GetMapping("buildings/myList")
	public List<BuildingDTO> getBuildingsPrioritize(@RequestParam long staffId, String prioritize) {
		return buildingService.getBuildingsPrioritize(staffId,prioritize);
	}
	
	@GetMapping("/building/detail")
	public BuildingDTO getbuilding(@RequestParam long id) {
		return buildingService.getBuilding(id);
	}

	@PostMapping("/buildings")
	public BuildingDTO saveBuilding(@RequestBody BuildingDTO buildingDTO) {
		return buildingService.saveBuilding(buildingDTO);
	}


	@GetMapping("/building/staff")
	public List<UserDTO> getUsers(@RequestParam long buildingid, @RequestParam String role) {
		List<UserDTO> listResult = userService.findAllStaff(buildingid, role);
		return listResult;
	}

	@PostMapping("/building/assignment")
	public boolean addManagerBuilding(@RequestBody AssignmentBuildingDTO assignmentBuildingDTO) {
		return assignmentBuildingService.assignmentBuilding(assignmentBuildingDTO);
	}
	
	@PutMapping("/building/edit")
	public boolean updateBuilding(@RequestBody BuildingDTO buildingDTO) {
		return buildingService.updateBuilding(buildingDTO);
	}

	@DeleteMapping("/building/delete")
	public boolean delBuilding(@RequestParam long buildingId) {  
		return buildingService.delBuilding(buildingId);
	}
	
	
	private BuildingSearchBuilder convertMapToBuilder(Map<String, String> requestParams, String[] type) {

		Integer numberOfBasement = requestParams.containsKey("numberOfBasement")
				? (StringUtils.isNoneBlank(requestParams.get("numberOfBasement"))
						? Integer.parseInt(requestParams.get("numberOfBasement"))
						: null)
				: null;
		Integer floorarea = requestParams.containsKey("floorarea")
				? (StringUtils.isNoneBlank(requestParams.get("floorarea"))
						? Integer.parseInt(requestParams.get("floorarea"))
						: null)
				: null;
		Integer rentAreaFrom = requestParams.containsKey("rentAreaFrom")
				? (StringUtils.isNoneBlank(requestParams.get("rentAreaFrom"))
						? Integer.parseInt(requestParams.get("rentAreaFrom"))
						: null)
				: null;
		Integer rentAreaTo = requestParams.containsKey("rentAreaTo")
				? (StringUtils.isNoneBlank(requestParams.get("rentAreaTo"))
						? Integer.parseInt(requestParams.get("rentAreaTo"))
						: null)
				: null;
		Integer rentPriceFrom = requestParams.containsKey("rentPriceFrom")
				? (StringUtils.isNoneBlank(requestParams.get("rentPriceFrom"))
						? Integer.parseInt(requestParams.get("rentPriceFrom"))
						: null)
				: null;
		Integer rentPriceTo = requestParams.containsKey("rentPriceTo")
				? (StringUtils.isNoneBlank(requestParams.get("rentPriceTo"))
						? Integer.parseInt(requestParams.get("rentPriceTo"))
						: null)
				: null;
		BuildingSearchBuilder builder = new BuildingSearchBuilder.Builder()
				.setName(requestParams.containsKey("name") ? requestParams.get("name") : null)
				.setNumberOfBasement(numberOfBasement)
				.setDirection(requestParams.containsKey("direction") ? requestParams.get("direction") : null)
				.setDistrict(requestParams.containsKey("district") ? requestParams.get("district") : null)
				.setFloorArea(floorarea)
				.setStreet(requestParams.containsKey("street") ? requestParams.get("street") : null)
				.setLevel(requestParams.containsKey("level") ? requestParams.get("level") : null)
				.setWard(requestParams.containsKey("ward") ? requestParams.get("ward") : null)
				.setRentAreaFrom(rentAreaFrom).setRentAreaTo(rentAreaTo).setRentPriceFrom(rentPriceFrom)
				.setRentPriceTo(rentPriceTo)
				.setManagerName(requestParams.containsKey("managerName")
						? requestParams.get("managerName")
						: null)
				.setManagerPhone(requestParams.containsKey("managerPhone")
						? requestParams.get("managerPhone")
						: null)
				.setStaffId(requestParams.containsKey("staffId")
						? requestParams.get("staffId")
						: null)
				.setTypes(type).build();
		return builder;
	}
}
