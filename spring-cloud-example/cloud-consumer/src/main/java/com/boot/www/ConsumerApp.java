package com.boot.www;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient // 开启服务发现
public class ConsumerApp {
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApp.class, args);
	}
	
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@RestController
	class EchoController {

		private final RestTemplate restTemplate;

		@Autowired
	    public EchoController(RestTemplate restTemplate) {this.restTemplate = restTemplate;}

		@GetMapping("/echo/{str}")
		public String echo(@PathVariable String str) {
			return "Consumer -- Hello Nacos Discovery " + str;
		}
		
		//通过注册中心 调用生产者服务
		@GetMapping("/call/{str}")
        public String echo1(@PathVariable String str) {
            return restTemplate.getForObject("http://service-provider/echo/" + str, String.class);
        }
	}
}
