package com.jci.tofs.sba;

import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

//@EnableEurekaClient
@SpringBootApplication
@ComponentScan
@EnableScheduling
@EnableSpringBootMetricsCollector
public class SBAClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SBAClientApplication.class, args);
	}

}
