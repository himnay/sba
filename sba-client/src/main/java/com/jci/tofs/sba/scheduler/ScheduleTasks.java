package com.jci.tofs.sba.scheduler;

import com.jci.tofs.sba.controller.BasicAuthRestTemplate;
import com.jci.tofs.sba.service.DeviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ScheduleTasks {

    private final DeviceService deviceService;
    private final BasicAuthRestTemplate restTemplate = new BasicAuthRestTemplate("onprem", "onprem");

    @Autowired
    public ScheduleTasks(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @Scheduled(initialDelay = 5000, fixedRate = 5000)
    public void scheduleUpdateDevice() {
//        businessService.updateDevice();
        restTemplate.put("http://localhost:8080/updateDevice", "");
    }
}
