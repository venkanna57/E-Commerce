package com.dbtraining.fundtransferapp.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dbtraining.fundtransferapp.dto.TransactionRequestDto;
import com.dbtraining.fundtransferapp.dto.TransactionResponseDto;
import com.dbtraining.fundtransferapp.dto.UserRequestDto;
import com.dbtraining.fundtransferapp.dto.UserResponseDto;
import com.dbtraining.fundtransferapp.entity.Account;
import com.dbtraining.fundtransferapp.entity.TransactionInfo;
import com.dbtraining.fundtransferapp.entity.User;
import com.dbtraining.fundtransferapp.repository.AccountRepository;
import com.dbtraining.fundtransferapp.repository.TransactionRepository;
import com.dbtraining.fundtransferapp.repository.UserRepository;
import com.dbtraining.fundtransferapp.entity.User;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	UserRepository userRepository;
    @Autowired
	AccountRepository accountRepository;
    @Autowired
    TransactionRepository transactionRepository;
	
	@Override
	public User userRegistration(User user) {
		
		
		return userRepository.save(user);	
	}
	
public String saveAccount(Account account){
		
		accountRepository.save(account);
		return "Account Crated Successfully";
	}

@Override
public TransactionResponseDto sendMoney(Long fromAccount, Long toAccount, Integer transferAmount) {
	TransactionResponseDto transactionResponseDto = new TransactionResponseDto();
	
	Account fromAccount1 = accountRepository.findByAccountNumberEquals(fromAccount);
	Account toAccount1 = accountRepository.findByAccountNumberEquals(toAccount);
	
	Integer srcBalance=fromAccount1.getBalanceAmount();
	Integer destinatonBalance = toAccount1.getBalanceAmount();
	srcBalance = srcBalance - transferAmount;
	destinatonBalance = destinatonBalance + transferAmount;
	
	fromAccount1.setBalanceAmount(srcBalance);
	accountRepository.save(fromAccount1);
	toAccount1.setBalanceAmount(destinatonBalance);
	accountRepository.save(toAccount1);
	//DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	//LocalDateTime localDateTime = LocalDateTime.now();
	
	TransactionInfo transactionInfo = new TransactionInfo();
	transactionInfo.setFromAccount(fromAccount);
	transactionInfo.setToAccount(toAccount);
	transactionInfo.setTransferAmount(transferAmount);
	transactionInfo.setAccount(fromAccount1);
	//transactionInfo.setTransferDate(dateTimeFormatter.o;
	transactionRepository.save(transactionInfo);
	transactionResponseDto.setMessage("Transaction Successfully Completed");
	transactionResponseDto.setStatusCode(HttpStatus.OK.value());
	
	return transactionResponseDto;
}


//return ResponseEntity<List<TransactionInfo>>();
	
	
	/*if(transactions.isPresent()){
		TransactionInfo transaction=transactions.get();
		TransactionRequestDto transactionRequestDto=new TransactionRequestDto();
		BeanUtils.copyProperties(transaction, transactionRequestDto);
		return transactionRequestDto;
	}
	return null;	*/



public List<TransactionInfo> getStatement(Long accountNumber){
	
	
	return transactionRepository.findByFromAccount(accountNumber);
}




}
