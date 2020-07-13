package com.dbtraining.fundtransferapp.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="transaction_info")
public class TransactionInfo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	Long transacitonId;
	Integer transferAmount;
	Long fromAccount;
	Long toAccount;
	
	@JoinColumn(name="accountId")
	@ManyToOne()
	Account account;
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Integer getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(Integer transferAmount) {
		this.transferAmount = transferAmount;
	}
	
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
}
