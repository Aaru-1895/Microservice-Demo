package com.microsub.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microsub.entity.SubjectEntity;
import com.microsub.model.ResponseData;
import com.microsub.model.UserEntity;
import com.microsub.repository.SubjectRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/subject")
public class SubjectController {
	
	
	@Autowired
	SubjectRepository subjectRepository;
	
	
	
	  @Autowired 
	  RestTemplate restTemplate;
	 
	
	@PostMapping("/savesub")
	public ResponseEntity<SubjectEntity> saveSub(@RequestBody SubjectEntity subjectEntity){
		SubjectEntity subject =subjectRepository.save(subjectEntity);
		return new ResponseEntity<SubjectEntity> (subject, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/getData/{id}")
	@HystrixCommand(fallbackMethod = "defaultFallBackForGetData")
	public ResponseEntity<ResponseData> getData(@PathVariable("id") int id){
		ResponseData responseData = new ResponseData();
		try {
			
			SubjectEntity subjectEntity = subjectRepository.findById(id).get();
			System.out.println("subjectEntity...."+subjectEntity);
			responseData.setSubjectEntity(subjectEntity);
			
			  List<UserEntity> userList= restTemplate.getForObject("http://localhost:9001/user/getUser/"+id,List.class);
			  System.out.println(userList);
			  responseData.setUserList(userList);
			 
				/* microservice-user */
		} catch (Exception e) {
			System.out.println("message.."+e.getMessage());
		}
		
		return new ResponseEntity<ResponseData> (responseData,HttpStatus.OK);
		
	}
	
	public ResponseEntity<ResponseData> defaultFallBackForGetData(@PathVariable("id") int id){
		ResponseData responseData = new ResponseData();
		try {
			
			SubjectEntity subjectEntity = subjectRepository.findById(id).get();
			System.out.println("subjectEntity...."+subjectEntity);
			responseData.setSubjectEntity(subjectEntity);
			 
		} catch (Exception e) {
			System.out.println("message.."+e.getMessage());
		}
		
		return new ResponseEntity<ResponseData> (responseData,HttpStatus.OK);
		
	}

}
