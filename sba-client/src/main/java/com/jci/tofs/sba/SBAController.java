package com.jci.tofs.sba;

import com.codahale.metrics.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@ManagedResource(objectName = "eventCount:name=SBAJMXManagedResource")
public class SBAController {

    private int eventCount = 0;

    @GetMapping("/log")
    @Timed(name = "pubLogging", absolute = true)
    public void pubLogging(){
        log.trace("Logging Trace");
        log.debug("Logging Debug");
        log.info("Logging Info");
        log.warn("Logging Warning");
        log.error("Logging Error");
    }

    @PutMapping("/addCount")
    @Timed(name = "incrementEventCount", absolute = true)
    public void incrementEventCount(){
        eventCount++;
    }

    @ManagedAttribute
    public int getEventCount() {
        return eventCount;
    }

    @ManagedAttribute
    public void setEventCount(int eventCount) {
        int oldValue = this.eventCount;
        this.eventCount = eventCount;
        log.info("Previous value {} new value {}", oldValue, this.eventCount);

    }

    /*@ManagedOperation
    public void logEventCount(String eventCount){
        int oldValue = this.eventCount;
        this.eventCount = Integer.parseInt(eventCount);
        log.info("Previous value {} new value {}", oldValue, this.eventCount);

    }*/

}
