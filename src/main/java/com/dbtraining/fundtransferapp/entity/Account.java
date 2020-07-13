package com.dbtraining.fundtransferapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "account")
public class Account {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
Integer accountId;
Long accountNumber;
String accountName;
Integer balanceAmount;
@JoinColumn(name="userId")
@OneToOne
User user;

public Integer getBalanceAmount() {
	return balanceAmount;
}
public void setBalanceAmount(Integer balanceAmount) {
	this.balanceAmount = balanceAmount;
}
public String getAccountName() {
	return accountName;
}
public void setAccountName(String accountName) {
	this.accountName = accountName;
}

public Integer getAccountId() {
	return accountId;
}
public void setAccountId(Integer accountId) {
	this.accountId = accountId;	
}

public Long getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(Long accountNumber) {
	this.accountNumber = accountNumber;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}



}
