package com.bala.osp.enrolmentauth.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.bala.osp.enrolmentauth.enums.Roles;

@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String password;
	private Date pwdValidFrom;
	private Date pwdValidTill;
	private String emailId;
	private Long mobileNumber;
	private Roles role;
	@OneToOne(cascade=CascadeType.ALL)
	private Address billingAddress;
	@OneToOne(cascade=CascadeType.ALL)
	private Address shippingAddress;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getPwdValidFrom() {
		return pwdValidFrom;
	}

	public void setPwdValidFrom(Date pwdValidFrom) {
		this.pwdValidFrom = pwdValidFrom;
	}

	public Date getPwdValidTill() {
		return pwdValidTill;
	}

	public void setPwdValidTill(Date pwdValidTill) {
		this.pwdValidTill = pwdValidTill;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

}
