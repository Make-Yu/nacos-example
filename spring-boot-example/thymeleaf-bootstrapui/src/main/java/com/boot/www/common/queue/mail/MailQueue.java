package com.boot.www.common.queue.mail;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class MailQueue {

	static final int QUEUE_MAX_VALUE = 1000;
	
	static BlockingQueue<Object> blockingQueue  = new LinkedBlockingDeque<>(QUEUE_MAX_VALUE);
	
	private MailQueue() {}
	
	public static class SingletonHolder{
		private static MailQueue queue = new MailQueue();
	}
	
	public static MailQueue getMailQueue() {
		return SingletonHolder.queue;
	}
	
	public void produce(Object obj) throws InterruptedException {
		blockingQueue.put(obj);
	}
	
	public Object consume() throws InterruptedException {
		return blockingQueue.take();
	}
	
	public int size() {
		return blockingQueue.size();
	}
}
