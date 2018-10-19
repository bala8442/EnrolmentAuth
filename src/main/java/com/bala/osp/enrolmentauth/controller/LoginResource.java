package com.bala.osp.enrolmentauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bala.osp.enrolmentauth.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@CrossOrigin
@RestController
public class LoginResource {

	@Autowired
	private UserService userService;

	@ApiOperation("Authenticate users")
	@GetMapping("/admin/login/{emailId}")
	public String validateAdminLogin(@RequestBody String password, @PathVariable("emailId") String emailId) {
		if(this.userService.authenticateUser(emailId, password)) {
			return "SUCCESS";
		}else {
			return "Failure";
		}
	}
}
