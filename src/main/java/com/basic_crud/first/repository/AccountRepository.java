package com.basic_crud.first.repository;

import org.springframework.data.jpa.repository.*;

import org.springframework.stereotype.Repository;

import com.basic_crud.first.model.*;


@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	

}
