package com.bala.osp.enrolmentauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bala.osp.enrolmentauth.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@CrossOrigin
@RestController
public class PasswordResource {
	
	@Autowired
	private UserService userService;
	
	@ApiOperation("Update Password")
	@PutMapping("/user/{emailId}")
	public void updatePassword(@RequestBody String password, @PathVariable("enmailId") String emailId) {
		this.userService.updatePassword(password, emailId);
	}

}
