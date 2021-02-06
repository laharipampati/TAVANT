package com.tav.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tav.test.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
