package com.dbtraining.fundtransferapp.dto;

public class UserResponseDto {
String message;
Integer statusCode;

public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Integer getStatusCode() {
	return statusCode;
}
public void setStatusCode(Integer statusCode) {
	this.statusCode = statusCode;
}

}
