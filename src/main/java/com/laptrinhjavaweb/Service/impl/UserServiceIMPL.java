package com.laptrinhjavaweb.Service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.laptrinhjavaweb.Convertor.GenericConvertor;
import com.laptrinhjavaweb.Convertor.UserConvertor;
import com.laptrinhjavaweb.Service.UserService;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.enity.UserEntity;
import com.laptrinhjavaweb.repository.JDBC.UserRepository;
import com.laptrinhjavaweb.repository.JDBC.impl.UserRepositoryIMPL;

public class UserServiceIMPL implements UserService {

	private UserRepository useRepository = new UserRepositoryIMPL();
	private UserConvertor userConvertor = new UserConvertor();
	private GenericConvertor<UserDTO, UserEntity> convertor = new GenericConvertor<>();

	@Override
	public List<UserDTO> findAllStaff(long buildingId, String role) {
		
		// syntax JAVA 7
	/*	List<UserDTO> result = new ArrayList<>();
		List<UserEntity> staffs = useRepository.findAllStaff(role);
		for (UserEntity userEntity : staffs) {
			UserDTO dto = userConvertor.convertToUserDTO(userEntity);
			if (useRepository.isAssignmentBuilding(dto.getId(), buildingId) ==  true) {
				dto.setChecked("checked");
			}
			result.add(dto);
		} */
		
		// syntax JAVA 8
		
		List<UserEntity> staffs = useRepository.findAllStaff(role);
		List<UserDTO> result = staffs.stream().map(item -> {
			UserDTO dto = convertor.convertorToDTO(item);
			if (useRepository.isAssignmentBuilding(dto.getId(), buildingId) ==  true) {
				dto.setChecked("checked");
			}
			return dto;
		}).collect(Collectors.toList());
		return result;
	}
}
