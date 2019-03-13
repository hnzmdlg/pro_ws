package com.ws;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan("com.ws.mapper")
//@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@ImportResource(value = {"classpath:dubbo-provider.xml"})
@EntityScan("com.ws.bean")
public class ProWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProWsApplication.class, args);
	}

}

