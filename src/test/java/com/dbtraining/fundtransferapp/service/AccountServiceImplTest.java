package com.dbtraining.fundtransferapp.service;

import java.util.List;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.dbtraining.fundtransferapp.entity.Account;
import com.dbtraining.fundtransferapp.entity.TransactionInfo;
import com.dbtraining.fundtransferapp.entity.User;
import com.dbtraining.fundtransferapp.repository.AccountRepository;
import com.dbtraining.fundtransferapp.repository.TransactionRepository;
import com.dbtraining.fundtransferapp.repository.UserRepository;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class AccountServiceImplTest {

	@InjectMocks
	AccountServiceImpl accountServiceImpl;	
    
    @Mock
	UserRepository userRepository;
    @Mock
	AccountRepository accountRepository;
    @Mock
    TransactionRepository transactionRepository;
    
    List<TransactionInfo> transactionInfo;
	
    @Test
    public void testUserRegistration(){
    	User  user = new User();
    	user.setUserName("venkat");
    	user.setPassword("venkat123");
    	user.setEmailId("venkat@gmail.com");
    	Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
    	User saveUser = accountServiceImpl.userRegistration(user);
    	Assert.assertNotNull(saveUser);
    	Assert.assertEquals("venkat@gmail.com", user.getEmailId());	
    }
 
   @Test
   public void testSaveAccount(){
  		Account account =  new Account();
		account.setAccountName("Santhosh");
		account.setAccountNumber(99887766544l);
		account.setBalanceAmount(10000);
		Mockito.when(accountRepository.save(Mockito.any(Account.class))).thenReturn(account);
    	accountServiceImpl.saveAccount(account);
    	Assert.assertEquals("Santhosh", account.getAccountName());
	
	}
 
 /*  @Test
   public void testGetStatement(){
	    transactionInfo =  (List<TransactionInfo>) new TransactionInfo();
	    
		((TransactionInfo) transactionInfo).setFromAccount(998877665544l);
		((TransactionInfo) transactionInfo).setToAccount(112233445566l);
		((TransactionInfo) transactionInfo).setTransferAmount(5000);
		Mockito.when(transactionRepository.findByFromAccount(998877665544l)).thenReturn(transactionInfo);
		List<TransactionInfo> ListOfTransations =	accountServiceImpl.getStatement(998877665544l);
		Assert.assertNotNull(ListOfTransations);
	}
    
    @Test
    public void testSendMoney(){
   
    	Account fromAccount1 = accountRepository.findByAccountNumberEquals(99887766544l);
    	Account toAccount1 = accountRepository.findByAccountNumberEquals(998877665775l);
    	
    	
    }
    */
	
}
