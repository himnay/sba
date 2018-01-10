package com.jci.tofs.sba.counter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;

@Slf4j
@Configuration
@ManagedResource(objectName = "messageCount:name=MessageCountMbean")
public class SBAMbean {

    private int messageCount = 0;

    @ManagedAttribute
    public int getMessageCount() {
        return messageCount;
    }

    @ManagedAttribute
    public void setMessageCount(int messageCount) {
        int oldValue = this.messageCount;
        this.messageCount = messageCount;
        log.info("Previous value {} new value {}", oldValue, this.messageCount);

    }

    /*@ManagedOperation
    public void logEventCount(String eventCount){
        int oldValue = this.eventCount;
        this.eventCount = Integer.parseInt(eventCount);
        log.info("Previous value {} new value {}", oldValue, this.eventCount);

    }*/

    public void incrementCount() {
        messageCount++;
    }
}
