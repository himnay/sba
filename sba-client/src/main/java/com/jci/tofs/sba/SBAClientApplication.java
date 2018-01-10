package com.jci.tofs.sba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

//@EnableEurekaClient
@SpringBootApplication
@ComponentScan
@EnableScheduling
public class SBAClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SBAClientApplication.class, args);
	}

}
