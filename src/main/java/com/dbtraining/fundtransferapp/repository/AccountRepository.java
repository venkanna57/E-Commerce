package com.dbtraining.fundtransferapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbtraining.fundtransferapp.entity.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findByAccountNumberEquals(Long accountNumber);
}
