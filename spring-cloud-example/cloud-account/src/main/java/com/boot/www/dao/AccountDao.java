package com.boot.www.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.www.entity.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Long>{

}
