package com.bala.osp.enrolmentauth.service;

public interface UserService {

	boolean authenticateUser(String emailId, String password);
	
	void updatePassword(String password, String emailId);
}
