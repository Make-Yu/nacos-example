package com.boot.www.service;

import com.boot.www.common.model.Email;
import com.boot.www.common.model.Result;

public interface IMailService {

	/**
	  * 纯文本
	  * @param mail
	  */
	 void send(Email mail) throws Exception;
	 /**
	  * 富文本
	  * @param mail
	  */
	  void sendHtml(Email mail) throws Exception;
	 /**
	  * 模版发送 freemarker
	  * @param mail
	  */
	  void sendFreemarker(Email mail) throws Exception;
	 /**
	  * 模版发送 thymeleaf(弃用、需要配合模板)
	  * @param mail
	  * @throws Exception 
	  */
	 void sendThymeleaf(Email mail) throws Exception;
	 /**
	  * 队列
	  * @param mail
	  *
	  */
	 void sendQueue(Email mail) throws Exception;
	 /**
	  * Redis 队列
	  * @param mail
	  */
//	 void sendRedisQueue(Email mail) throws Exception;

   /**
    * 邮件列表
    * @param mail
    * @return
    */
	 Result listMail(Email mail);
}
