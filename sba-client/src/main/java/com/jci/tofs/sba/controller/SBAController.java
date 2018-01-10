package com.jci.tofs.sba.controller;

import com.codahale.metrics.annotation.Timed;
import com.jci.tofs.sba.CurrentTimeEndpoint;
import com.jci.tofs.sba.service.BusinessService;
import com.jci.tofs.sba.counter.SBAMbean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SBAController {

    private final BusinessService businessService;
    private final SBAMbean mbean;

    @Autowired
    public SBAController(BusinessService businessService, SBAMbean mbean){
        this.businessService = businessService;
        this.mbean = mbean;
    }

    @PutMapping("/log")
    @Timed(name = "pubLogging", absolute = true)
    public void pubLogging(){
        log.trace("Logging Trace");
        log.debug("Logging Debug");
        log.info("Logging Info");
        log.warn("Logging Warning");
        log.error("Logging Error");
    }

    @PutMapping("/updateDevice")
    @Timed(name = "incrementEventCount", absolute = true)
    public void incrementEventCount(){
        log.info("REST : update device...");
        mbean.incrementCount();
        businessService.updateDevice();
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
