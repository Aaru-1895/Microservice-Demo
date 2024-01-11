package com.microuser.MicrroserviceUser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microuser.MicrroserviceUser.entity.UserEntity;
import com.microuser.MicrroserviceUser.repository.userRepository;
import com.microuser.MicrroserviceUser.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	userRepository userRepository;
	
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping(path="/get")
	public ResponseEntity<String>  getUser() {
		return new ResponseEntity<>("Hello", HttpStatus.OK);
		
		
	}
	
	
	@PostMapping("/saveUser")
	public  ResponseEntity<UserEntity> saveuser(@RequestBody UserEntity userEntity){
		UserEntity user = userRepository.save(userEntity);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping("/getUser/{id}")
	public  ResponseEntity<List<UserEntity>> getuserById(@PathVariable ("id") Integer id){
		//List<UserEntity> list = userRepository.findbySubjectId(id);
		List<UserEntity> userEntity = userService.finduser(id);
		
		System.out.println("userEntity...."+userEntity);
		return new ResponseEntity<>(userEntity, HttpStatus.OK);
	}
	

}
