package com.boot.www.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.boot.www.dao.AccountDao;
import com.boot.www.entity.Account;
import com.boot.www.service.AccountService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;

	@Override
	public void debit(String userId, int money) {
//		 accountDao.updateMoneyByUserId(money,userId);

		Account account = new Account();
		account.setUserId(userId);
		Example<Account> example = Example.of(account);
		Optional<Account> opt = accountDao.findOne(example);
		account = opt.get();
		account.setMoney(account.getMoney() - money);

		accountDao.save(account);
		log.info("Account Service End ... ");
	}

}
