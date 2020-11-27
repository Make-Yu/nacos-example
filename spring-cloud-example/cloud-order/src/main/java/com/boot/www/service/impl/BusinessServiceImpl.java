package com.boot.www.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.www.client.StorageClient;
import com.boot.www.service.BusinessService;
import com.boot.www.service.OrderService;

import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BusinessServiceImpl implements BusinessService {

	@Autowired
	private StorageClient storageClient;
	@Autowired
    private OrderService orderService;


    @Override
    @GlobalTransactional(timeoutMills = 300000)
    public void purchase(String userId, String commodityCode, int orderCount) {
        log.info("purchase begin ... xid: " + RootContext.getXID());
        storageClient.deduct(commodityCode, orderCount);
        orderService.create(userId, commodityCode, orderCount);
        throw new RuntimeException("xxx");
    }

}
