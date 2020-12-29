package com.boot.www.service;

public interface QueueService {

	void sendQueue(Object obj) throws Exception;
	
	void send(Object obj);
}
