package com.boot.www.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.www.client.AccountClient;
import com.boot.www.dao.OrdersDao;
import com.boot.www.entity.Order;
import com.boot.www.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrdersDao ordersDao;
	@Autowired
	private AccountClient accountClient;
	
	@Override
	public Order add(Order orders) {
		return ordersDao.save(orders);
	}

	@Override
	public Order getById(long id) {
		Optional<Order> o = ordersDao.findById(id);
		if (o.isPresent())
			return o.get();
		return null;
	}

	@Override
	public Order create(String userId, String commodityCode, int orderCount) {
		// 计算订单金额
		int orderMoney = 200 * orderCount;

		// 从账户余额扣款
		accountClient.debit(userId, orderMoney);

//		KeyHolder keyHolder = new GeneratedKeyHolder();

		Order orders = new Order();
		orders.setCommodityCode(commodityCode);
		orders.setCount(orderCount);
		orders.setUserId(userId);
		orders.setMoney(orderMoney);

		ordersDao.save(orders);
		log.info("Order Service End ... Created " + orders);
		return orders;
	}
}
