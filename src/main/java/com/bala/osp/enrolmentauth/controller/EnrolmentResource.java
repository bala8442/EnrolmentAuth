package com.bala.osp.enrolmentauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bala.osp.enrolmentauth.domain.Users;
import com.bala.osp.enrolmentauth.service.EnrolmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@CrossOrigin
public class EnrolmentResource {

	@Autowired
	private EnrolmentService enrolmentService;
	
	@ApiOperation("Admin Enrolment")
	@PostMapping("/admin")
	public ResponseEntity<Users> createAdmin(@RequestBody Users admin) throws Exception {
		try {
			this.enrolmentService.RegisterAdmin(admin);
			return ResponseEntity.ok(admin);
		}catch (Exception e) {
			throw new Exception();
		}
	}
	
	@ApiOperation("Buyer Enrolment")
	@PostMapping("/buyer")
	public ResponseEntity<Users> createBuyer(@RequestBody Users buyer) throws Exception {
		try {
			this.enrolmentService.RegisterBuyer(buyer);
			return ResponseEntity.ok(buyer);
		}catch (Exception e) {
			throw new Exception();
		}
	}
}
