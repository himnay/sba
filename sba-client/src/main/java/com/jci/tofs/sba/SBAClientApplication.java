package com.jci.tofs.sba;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
//@EnableEurekaClient
@SpringBootApplication
public class SBAClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SBAClientApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "UP";
	}

	@Bean
	CurrentTimeEndpoint currentTimeEndpoint() {
		return new CurrentTimeEndpoint();
	}

	/*@Bean
	SocketHealthIndicator socketHealthIndicator() {
		SocketHealthIndicator indicator = new SocketHealthIndicator();
		indicator.setHost("localhost");
		indicator.setPort(8080);
		return indicator;
	}*/
}
