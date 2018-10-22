package com.bala.osp.enrolmentauth.service;

import com.bala.osp.enrolmentauth.domain.Address;
import com.bala.osp.enrolmentauth.domain.Users;

public interface UserService {

	boolean authenticateUser(String emailId, String password);
	
	Users updatePassword(String password, String emailId);
	
	Users updateBillingAddress(String emailId, Address address);
	
	Users updateShippingAddress(String emailId, Address address);
}
