package com.boot.www.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StorageClient {

	@Autowired
	private RestTemplate restTemplate;


	public void deduct(String commodityCode, int count) {
		
		restTemplate.put("http://service-storage/storage/deduct?commodityCode="+commodityCode+"&count="+count, String.class);
	}

}
