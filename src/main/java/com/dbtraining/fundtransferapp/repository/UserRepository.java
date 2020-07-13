package com.dbtraining.fundtransferapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbtraining.fundtransferapp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
