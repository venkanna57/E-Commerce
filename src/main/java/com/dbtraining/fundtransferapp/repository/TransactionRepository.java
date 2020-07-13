package com.dbtraining.fundtransferapp.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbtraining.fundtransferapp.entity.Account;
import com.dbtraining.fundtransferapp.entity.TransactionInfo;
@Repository
public interface TransactionRepository extends JpaRepository<TransactionInfo, Long>{

public	List<TransactionInfo>	findByFromAccount(Long fromAccount);

}
