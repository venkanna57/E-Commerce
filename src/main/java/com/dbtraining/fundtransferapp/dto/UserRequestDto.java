package com.dbtraining.fundtransferapp.dto;

import javax.persistence.Id;

public class UserRequestDto {
	
Integer userId;
String userName;
String password;
Integer mobileNumber;
String emailId;

public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public Integer getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(Integer mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}

}
