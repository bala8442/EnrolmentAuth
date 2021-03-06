package com.bala.osp.enrolmentauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bala.osp.enrolmentauth.domain.Address;
import com.bala.osp.enrolmentauth.domain.Users;
import com.bala.osp.enrolmentauth.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@CrossOrigin
@RestController
public class UserResource {

	@Autowired
	private UserService userService;

	@ApiOperation("Authenticate users")
	@PostMapping("/admin/login/{emailId}")
	public Users validateAdminLogin(@RequestBody String password, @PathVariable("emailId") String emailId) {
		return this.userService.authenticateUser(emailId, password);
	}
	
	@ApiOperation("Authenticate users")
	@PostMapping("/buyer/login/{emailId}")
	public Users validateBuyerLogin(@RequestBody String password, @PathVariable("emailId") String emailId) {
		return this.userService.authenticateUser(emailId, password);
	}
	
	@ApiOperation("Authenticate users")
	@GetMapping("/users/{emailId}")
	public Users getUSerDetails(@PathVariable("emailId") String emailId) {
		return this.userService.getUser(emailId);
	}
	
	@ApiOperation("Update Billing Address")
	@PutMapping("/user/{emailId}/billingAddress")
	public Users updateBillingAddress(@RequestBody Address address, @PathVariable("emailId") String emailId) {
		return this.userService.updateBillingAddress(emailId, address);
	}
	
	@ApiOperation("Update Shipping Address")
	@PutMapping("/user/{emailId}/shippingAddress")
	public Users updateShippingAddress(@RequestBody Address address, @PathVariable("emailId") String emailId) {
		return this.userService.updateShippingAddress(emailId, address);
	}
}
