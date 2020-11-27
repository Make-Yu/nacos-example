package com.boot.www.service;

import com.boot.www.entity.Order;

public interface OrderService {

	Order add(Order orders);
	
	Order getById(long id);
	
	/**
     * 创建订单
     */
	Order create(String userId, String commodityCode, int orderCount);
}

