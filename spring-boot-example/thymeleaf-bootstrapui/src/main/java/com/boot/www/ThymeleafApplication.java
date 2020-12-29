package com.boot.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableKnife4j
@SpringBootApplication
public class ThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafApplication.class, args);
	}
	
	@Bean
	public Docket createRestfulApi() {
		return new Docket(DocumentationType.SWAGGER_2).enable(true).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.boot.www.controller")).paths(PathSelectors.any()).build();
	}

	// 预览地址:swagger-ui.html
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Knife4j构建文档").termsOfServiceUrl("http://....")
				.contact(new Contact("TT", "http://...", "anzai66@sina.com")).version("1.1").build();
	}
}
