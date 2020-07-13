package com.dbtraining.fundtransferapp.controller;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbtraining.fundtransferapp.dto.AccountStatementRequest;
import com.dbtraining.fundtransferapp.dto.TransactionRequestDto;
import com.dbtraining.fundtransferapp.dto.TransactionResponseDto;
import com.dbtraining.fundtransferapp.dto.UserRequestDto;
import com.dbtraining.fundtransferapp.dto.UserResponseDto;
import com.dbtraining.fundtransferapp.entity.Account;
import com.dbtraining.fundtransferapp.entity.TransactionInfo;
import com.dbtraining.fundtransferapp.entity.User;
import com.dbtraining.fundtransferapp.service.AccountService;

@RestController
@RequestMapping("/Customers")
public class AccountController {
	
	private static Logger logger = LoggerFactory.getLogger(AccountController.class);
	
    @Autowired
	AccountService accountService;
    
	@PostMapping("")
	public ResponseEntity<String> userRegistration(@RequestBody User user){
		
		logger.debug("UserRegistration Page+++++++++++++"); 
		accountService.userRegistration(user);
		Random random=new Random();
		Long accountNumber=generateRandom(12);
		Account account=new Account();
		account.setAccountNumber(accountNumber);
		account.setAccountName(user.getUserName());
		account.setBalanceAmount(10000);
		account.setUser(user);
		accountService.saveAccount(account);
	    return new ResponseEntity<String>("Registraton is Completed And User Account Created Successfully", HttpStatus.CREATED);	
	}
	
	public long generateRandom(int length) {
		
	    Random random = new Random();
	    char[] digits = new char[length];
	    digits[0] = (char) (random.nextInt(9) + '1');
	    for (int i = 1; i < length; i++) {
	        digits[i] = (char) (random.nextInt(10) + '0');
	    }
	    return Long.parseLong(new String(digits));
	}
	
	@PostMapping("/transferamount")
	public ResponseEntity<TransactionResponseDto> sendMoney(@RequestParam Long fromAccount, @RequestParam Long toAccount, @RequestParam Integer transferAmount){
		
		logger.debug("Fundtransfer from one account to another account++++++++++");
		
		TransactionResponseDto transactionResponseDto=accountService.sendMoney(fromAccount,toAccount,transferAmount);
		
		return new ResponseEntity<TransactionResponseDto>(transactionResponseDto, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/{Id}")
	public List<TransactionInfo>  getStatement(@RequestParam Long accountNumber){
		
		logger.debug("Last recent five transations+++++++++++++");
	
	return accountService.getStatement(accountNumber);
		
	}	
	
}
