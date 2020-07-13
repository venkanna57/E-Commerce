package com.dbtraining.fundtransferapp.dto;

import java.util.List;

public class TransactionResponseDto {

	String message;
	Integer statusCode;
	List<TransactionRequestDto> transactionsCompleted;
	
	public List<TransactionRequestDto> getTransactionsCompleted() {
		return transactionsCompleted;
	}
	public void setTransactionsCompleted(List<TransactionRequestDto> transactionsCompleted) {
		this.transactionsCompleted = transactionsCompleted;
	}
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
