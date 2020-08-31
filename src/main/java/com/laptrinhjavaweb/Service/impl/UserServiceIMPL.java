package com.laptrinhjavaweb.Service.impl;

import java.util.ArrayList;
import java.util.List;

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
	public List<UserDTO> findAllUser(long buildingId) {
		List<UserDTO> result = new ArrayList<>();
		List<UserEntity> staffs = useRepository.findAllUser();
		for (int i = 0; i < staffs.size(); i++) {
			UserDTO dto = userConvertor.convertToUserDTO(staffs.get(i));
			if (useRepository.isAssignmentBuilding(dto.getId(), buildingId) ==  true) {
				dto.setChecked("checked");
			}
			result.add(dto);
		}
		return result;
	}
}
