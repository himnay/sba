package com.jci.tofs.sba;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ScheduleTasks {

    private final BusinessService businessService;

    @Autowired
    public ScheduleTasks(BusinessService businessService) {
        this.businessService = businessService;
    }

    @Scheduled(fixedRate = 5000)
    public void scheduleUpdateDevice() {
        businessService.updateDevice();
        log.info("calling update device");
    }
}
