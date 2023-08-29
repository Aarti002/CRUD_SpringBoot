package com.basic_crud.first.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.basic_crud.first.repository.*;
import com.basic_crud.first.model.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class AccountController {
	
	private AccountRepository repo;
	
	@Autowired
	public void setAccountRepository(AccountRepository accRepo) {
        this.repo = accRepo;
    }

  @GetMapping("/getAccounts")
  public List<Account> getAccounts(){
	 List<Account> res=repo.findAll();
    return res;
  }
  
  @PostMapping("/addAccount")
  public String addAccount(@RequestBody Account acc) {
	  Account newAcc=new Account();
	  newAcc.setName(acc.getName());
	  newAcc.setEmail(acc.getEmail());
	  newAcc.setPhone(acc.getPhone());
	  repo.save(acc);
	  return "Added";
  }
  
  @PutMapping("/editAccount/{id}")
  public String editAccount(@PathVariable("id") int id, @RequestBody Account account) {
	  Account acc=repo.findById(id).get();
	  if(Objects.isNull(acc))
		  return null;
	  String updates="";
	  if(Objects.nonNull(account.getName()) && !"".equalsIgnoreCase(account.getName())) {
		  acc.setName(account.getName());
	  }
	  else {
		  updates+="Name, ";
	  }
	  if(Objects.nonNull(account.getEmail()) && !"".equalsIgnoreCase(account.getEmail())) {
		  acc.setEmail(account.getEmail());
	  }
	  else {
		  updates+="Email, ";
	  }
	  if(Objects.nonNull(account.getPhone()) && !"".equalsIgnoreCase(account.getPhone())) {
		  acc.setPhone(account.getPhone());
	  }
	  else {
		  updates+="Phone ";
	  }
	  if(!updates.isEmpty()) {
		  updates+="has not been updated!";
	  }
	  repo.save(acc);
	  return updates;
  }
  
  @GetMapping("/getAccount/{id}")
  public Account getAccount(@PathVariable("id") int id) {
	  Account acc=repo.findById(id).get();
	  if(!Objects.isNull(acc))
	  {
		  return acc;
	  }
	  else {
		  return null;
	  }
	  
  }
  
  @DeleteMapping("/deleteAccount/{id}")
  public String deleteAccount(@PathVariable("id") int id) {
	  Account acc=repo.findById(id).get();
	  if(Objects.isNull(acc)) {
		  return null;
	  }
	  repo.deleteById(id);
	  return "Successfully Deleted!";
  }
  
  
}