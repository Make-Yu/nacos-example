package com.boot.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.www.service.BusinessService;
import com.boot.www.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	OrderService ordersService;
	@Autowired
	BusinessService businessService;

	@GetMapping("/find/{id}")
	public Object getUser(@PathVariable long id) {
		return ordersService.getById(id);
	}

	@PostMapping("purchase")
	public void purchase(String userId, String commodityCode, int orderCount) {
		log.info("params:{},{},{}",userId,commodityCode,orderCount);
		businessService.purchase(userId, commodityCode, orderCount);
		log.info("Order Controller End...");
	}
}
