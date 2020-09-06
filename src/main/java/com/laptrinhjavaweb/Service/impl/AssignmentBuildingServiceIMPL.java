package com.laptrinhjavaweb.Service.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.Service.AssignmentBuildingService;
import com.laptrinhjavaweb.dto.AssignmentBuildingDTO;
import com.laptrinhjavaweb.repository.JDBC.AssignmentBuildingRepository;
import com.laptrinhjavaweb.repository.JDBC.impl.AssignmentBuildingRepositoryIMPL;

public class AssignmentBuildingServiceIMPL implements AssignmentBuildingService {

	private AssignmentBuildingRepository assignmentBuildingRepository = new AssignmentBuildingRepositoryIMPL();

	@Override
	public boolean assignmentBuilding(AssignmentBuildingDTO assignmentBuildingDTO) {
		List<Long> newUserds = getNewStaffIds(assignmentBuildingDTO.getStaffId());
		List<Long> oldUserIds = assignmentBuildingRepository.getStaffIds(assignmentBuildingDTO.getBuildingId());
		List<Long> isCheckedUsers = new ArrayList<>();
		List<Long> unCheckedUsers = new ArrayList<>();
		boolean flag = false;
		for (Long newUserd : newUserds) {
			if (!oldUserIds.contains(newUserd)) {
				isCheckedUsers.add(newUserd);
			}
		}
		for (Long oldUserId : oldUserIds) {
			if (!newUserds.contains(oldUserId)) {
				unCheckedUsers.add(oldUserId);
			}
		}
		flag = assignmentBuildingRepository.assignBuilding(isCheckedUsers,unCheckedUsers, assignmentBuildingDTO.getBuildingId());
		return flag;
	}

	private List<Long> getNewStaffIds(Long[] staffId) {
		List<Long> result = new ArrayList<Long>();
		for (Long long1 : staffId) {
			result.add(long1);
		}
		return result;
	}

}
