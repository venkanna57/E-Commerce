package com.dbtraining.fundtransferapp.dto;

public class TransactionRequestDto {
	Long transacitonId;
	Long fromAccount;
	Long toAccount;
	Integer transferAmount;
	public Long getTransacitonId() {
		return transacitonId;
	}
	public void setTransacitonId(Long transacitonId) {
		this.transacitonId = transacitonId;
	}
	public Long getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}
	public Long getToAccount() {
		return toAccount;
	}
	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}
	public Integer getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(Integer transferAmount) {
		this.transferAmount = transferAmount;
	}

}
