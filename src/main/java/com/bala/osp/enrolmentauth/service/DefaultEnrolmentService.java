package com.bala.osp.enrolmentauth.service;




import static com.bala.osp.enrolmentauth.enums.Roles.Admin;
import static com.bala.osp.enrolmentauth.enums.Roles.Buyer;
import static com.bala.osp.enrolmentauth.util.CommonUtils.addDays;
import static com.bala.osp.enrolmentauth.util.CommonUtils.today;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bala.osp.enrolmentauth.domain.Users;
import com.bala.osp.enrolmentauth.repository.UserRepository;

@Service
public class DefaultEnrolmentService implements EnrolmentService{
	
	@Autowired
	private UserRepository userRepository;

	public void RegisterAdmin(Users admin) {
		if(null!=admin && null!=admin.getPassword()) {
			admin.setPwdValidFrom(today());
			admin.setPwdValidTill(addDays(60));
			admin.setRole(Admin);
			this.userRepository.save(admin);
		}
	}

	@Override
	public void RegisterBuyer(Users buyer) {
		if(null!= buyer && null!=buyer.getPassword()) {
			buyer.setPwdValidFrom(today());
			buyer.setPwdValidTill(addDays(30));
			buyer.setRole(Buyer);
			this.userRepository.save(buyer);
		}
	}
}
