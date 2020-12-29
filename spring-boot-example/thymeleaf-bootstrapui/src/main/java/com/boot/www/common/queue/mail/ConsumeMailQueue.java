package com.boot.www.common.queue.mail;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boot.www.service.QueueService;

@Component
public class ConsumeMailQueue {
	
	private static final Logger logger = LoggerFactory.getLogger(ConsumeMailQueue.class);

	@Autowired
	QueueService queueService;
	
	@PostConstruct
	public void startThread() {
		ExecutorService ex = Executors.newFixedThreadPool(2);
		ex.submit(new PollMail(queueService));
		ex.submit(new PollMail(queueService));
	}
	
	class PollMail implements Runnable{
		
		QueueService queueService;
		
		public PollMail(QueueService queueService) {
			this.queueService = queueService;
		}

		@Override
		public void run() {
			while (true) {
				try {
					Object obj = MailQueue.getMailQueue().consume();
					if(obj!=null) {
						logger.info("剩余邮件总数:{}",MailQueue.getMailQueue().size());
						queueService.send(obj);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@PreDestroy
	public void stopThread() {
		logger.info("destroy");
	}
}
