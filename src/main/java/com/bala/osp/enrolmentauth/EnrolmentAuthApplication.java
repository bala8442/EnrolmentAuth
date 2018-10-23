package com.bala.osp.enrolmentauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EnrolmentAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnrolmentAuthApplication.class, args);
	}
}
