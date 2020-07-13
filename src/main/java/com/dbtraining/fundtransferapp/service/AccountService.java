package com.dbtraining.fundtransferapp.service;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.dbtraining.fundtransferapp.dto.TransactionRequestDto;
import com.dbtraining.fundtransferapp.dto.TransactionResponseDto;
import com.dbtraining.fundtransferapp.dto.UserRequestDto;
import com.dbtraining.fundtransferapp.dto.UserResponseDto;
import com.dbtraining.fundtransferapp.entity.Account;
import com.dbtraining.fundtransferapp.entity.TransactionInfo;
import com.dbtraining.fundtransferapp.entity.User;


public interface AccountService {
	User  userRegistration(User user);

	String saveAccount(Account account);
	
	TransactionResponseDto sendMoney(Long fromAccount, Long toAccount, Integer transferAmount);
	List<TransactionInfo> getStatement(Long findByAccountNumber);
	
}

