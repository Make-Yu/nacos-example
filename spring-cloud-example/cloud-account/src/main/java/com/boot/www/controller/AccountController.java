package com.boot.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.www.service.AccountService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("account")
@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PutMapping("debit")
	public void debit(String userId, int money) {
		accountService.debit(userId, money);
		log.info("Account Controller End ... ");
	}
}
