package com.boot.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.www.common.model.Email;
import com.boot.www.common.model.Result;
import com.boot.www.service.IMailService;

@RestController
@RequestMapping("/mail")
public class MailController {
	
//	@Autowired
//	QueueService QueueService;
//
//	@GetMapping("send")
//	public void send() {
//		for (int i = 1; i <= 10; i++) {
//			try {
//				QueueService.sendQueue("第一份"+i);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
	
	
	@Autowired
	private IMailService mailService;

    /**
     * 简单测试
     * @param mail
     * @return
     */
	@PostMapping("send")
	public Result send(Email mail) {
		try {
			mailService.sendFreemarker(mail);
		} catch (Exception e) {
			e.printStackTrace();
			return  Result.error();
		}
		return  Result.ok();
	}

    /**
     * 列表
     * @param mail
     * @return
     */
	@PostMapping("list")
	public Result list(Email mail) {
		return mailService.listMail(mail);
	}

    /**
     * 队列测试
     * @param mail
     * @return
     */
    @PostMapping("queue")
    public Result queue(Email mail) {
        try {
            mailService.sendQueue(mail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  Result.ok();
    }
    
    /**
     * 队列测试
     * @param mail
     * @return
     */
    @PostMapping("sendFreemarker")
    public Result sendFreemarker(Email mail) {
        try {
            mailService.sendFreemarker(mail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  Result.ok();
    }
    
    /**
     * 队列测试
     * @param mail
     * @return
     */
    @PostMapping("sendThymeleaf")
    public Result sendThymeleaf(Email mail) {
        try {
            mailService.sendThymeleaf(mail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  Result.ok();
    }
}
