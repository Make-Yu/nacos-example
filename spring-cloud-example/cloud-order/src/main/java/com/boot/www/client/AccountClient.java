package com.boot.www.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AccountClient {

	@Autowired
	private RestTemplate restTemplate;

	public void debit(String userId, int money) {
		restTemplate.put("http://service-account/account/debit?userId="+userId+"&money="+money, String.class);
	}

}
