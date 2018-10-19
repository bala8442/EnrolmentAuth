package com.bala.osp.enrolmentauth.service;

import com.bala.osp.enrolmentauth.domain.Users;

public interface EnrolmentService {

	void RegisterAdmin(Users admin);
	
	void RegisterBuyer(Users buyer);
}
