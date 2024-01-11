package com.microuser.MicrroserviceUser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microuser.MicrroserviceUser.entity.UserEntity;


@Repository
public interface userRepository extends JpaRepository<UserEntity, Integer>{

	List<UserEntity> findBySubjectId(Integer id);
	
	

}
