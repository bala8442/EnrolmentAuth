package com.bala.osp.enrolmentauth.service;

import static com.bala.osp.enrolmentauth.enums.Roles.Admin;
import static com.bala.osp.enrolmentauth.util.CommonUtils.addDays;
import static com.bala.osp.enrolmentauth.util.CommonUtils.today;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bala.osp.enrolmentauth.domain.Users;
import com.bala.osp.enrolmentauth.repository.UserRepository;

@Service
public class DefaultUserService implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean authenticateUser(String emailId, String password) {
		Users user = this.userRepository.findByEmailId(emailId);
		if(user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public void updatePassword(String password, String emailId) {		
		Users user = this.userRepository.findByEmailId(emailId);
		user.setPassword(password);
		user.setPwdValidFrom(today());		
		if(user.getRole().equals(Admin)) {
			user.setPwdValidTill(addDays(60));
		}else {
			user.setPwdValidTill(addDays(30));
		}
		userRepository.save(user);
	}

}
