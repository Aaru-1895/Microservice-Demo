package com.microuser.MicrroserviceUser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microuser.MicrroserviceUser.entity.UserEntity;
import com.microuser.MicrroserviceUser.repository.userRepository;

@Service
public class UserService {
	
	
	@Autowired
	userRepository userRepository;
	
	public List<UserEntity> finduser(Integer id) {
		return userRepository.findBySubjectId(id);
	}

}
