package com.bala.osp.enrolmentauth.service;

import static com.bala.osp.enrolmentauth.enums.Roles.Admin;
import static com.bala.osp.enrolmentauth.util.CommonUtils.addDays;
import static com.bala.osp.enrolmentauth.util.CommonUtils.today;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bala.osp.enrolmentauth.domain.Address;
import com.bala.osp.enrolmentauth.domain.Users;
import com.bala.osp.enrolmentauth.repository.UserRepository;

@Service
public class DefaultUserService implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Users authenticateUser(String emailId, String password) {
		Users user = getUserByEmailId(emailId);
		if(user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	@Override
	public Users updatePassword(String password, String emailId) {		
		Users user = getUserByEmailId(emailId);
		user.setPassword(password);
		user.setPwdValidFrom(today());		
		if(user.getRole().equals(Admin)) {
			user.setPwdValidTill(addDays(60));
		}else {
			user.setPwdValidTill(addDays(30));
		}
		userRepository.save(user);
		return user;
	}

	@Override
	public Users updateBillingAddress(String emailId, Address address) {
		Users user = getUserByEmailId(emailId);
		address.setBilling(true);
		user.setBillingAddress(address);
		this.userRepository.save(user);
		return user;
	}

	private Users getUserByEmailId(String emailId) {
		return this.userRepository.findByEmailId(emailId);
	}

	@Override
	public Users updateShippingAddress(String emailId, Address address) {
		Users user = getUserByEmailId(emailId);
		address.setShipping(true);
		user.setShippingAddress(address);
		this.userRepository.save(user);
		return user;
	}

	@Override
	public Users getUser(String emailId) {
		return this.userRepository.findByEmailId(emailId);
	}

}
