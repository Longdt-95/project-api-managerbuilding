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
	public List<UserDTO> findAllUser(long id) {
		List<UserDTO> listAllUser = new ArrayList<>();
		List<UserDTO> listUserAssignmentBuilding = new ArrayList<>();
		List<UserEntity> listUserEntity = new ArrayList<UserEntity>();
		for (UserEntity userEntity : useRepository.getUsersAssignmentBuildingByBuildingID(id)) {
			UserDTO dto = userConvertor.convertToUserDTO(userEntity);
			listUserAssignmentBuilding.add(dto);
		}
		listUserEntity = useRepository.findAllUser();
		for (int i = 0; i < listUserEntity.size(); i++) {
			UserDTO dto = userConvertor.convertToUserDTO(listUserEntity.get(i));
			for (UserDTO userDTO : listUserAssignmentBuilding) {
				if (userDTO.getId() == dto.getId()) {
					dto.setChecked("checked");
					break;
				} else
					dto.setChecked("");
			}
			listAllUser.add(dto);
		}
		return listAllUser;
	}
}
