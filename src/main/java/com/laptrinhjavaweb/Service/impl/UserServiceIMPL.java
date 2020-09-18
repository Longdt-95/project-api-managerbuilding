package com.laptrinhjavaweb.Service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.laptrinhjavaweb.Convertor.UserConvertor;
import com.laptrinhjavaweb.Service.UserService;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.enity.UserEntity;
import com.laptrinhjavaweb.repository.JDBC.UserRepository;
import com.laptrinhjavaweb.repository.JDBC.impl.UserRepositoryIMPL;

public class UserServiceIMPL implements UserService {

	private UserRepository useRepository = new UserRepositoryIMPL();
	private UserConvertor userConvertor = new UserConvertor();

	@Override
	public List<UserDTO> findAllUser(long buildingId, String role) {
		List<UserEntity> staffs = useRepository.findAllUser(role);
		/*for (UserEntity userEntity: staffs) {
			UserDTO dto = userConvertor.convertToUserDTO(userEntity);
			if (useRepository.isAssignmentBuilding(dto.getId(), buildingId) ==  true) {
				dto.setChecked("checked");
			}
			result.add(dto);
		}*/
		List<UserDTO> result = staffs.stream().map(item -> {
			UserDTO dto = userConvertor.convertToUserDTO(item);
			if (useRepository.isAssignmentBuilding(dto.getId(), buildingId) ==  true) {
				dto.setChecked("checked");
			}
			return dto;
		}).collect(Collectors.toList());
		return result;
	}
}
