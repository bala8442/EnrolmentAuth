package com.bala.osp.enrolmentauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bala.osp.enrolmentauth.domain.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
	
	Users findByEmailId(String emailId);

}
