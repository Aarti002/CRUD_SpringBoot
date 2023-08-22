package com.basic_crud.first.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic_crud.first.model.Account;
import com.basic_crud.first.repository.AccountRepository;

@Service
public class AccountService {
	        @Autowired
	       private AccountRepository repo;     

	       public List<Account> getAccounts(){
	            return (List<Account>) repo.findAll();
	        }

}
