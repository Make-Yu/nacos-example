package com.boot.www.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.boot.www.common.queue.mail.MailQueue;
import com.boot.www.service.QueueService;

@Service
public class QueueServiceImpl implements QueueService{
	
	private static final Logger logger = LoggerFactory.getLogger(QueueServiceImpl.class);

	@Override
	public void sendQueue(Object obj) throws Exception {
		MailQueue.getMailQueue().produce(obj);
	}

	@Override
	public void send(Object obj) {
		logger.info("发送：{}",obj);
	}

}
