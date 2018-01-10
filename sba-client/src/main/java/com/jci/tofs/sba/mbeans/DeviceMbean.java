package com.jci.tofs.sba.mbeans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;

@Slf4j
@Configuration
@ManagedResource(objectName = "sba-client:name=MessageCountMbean")
public class DeviceMbean {

    private int messageCount = 0;
    private boolean flag = true;

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

    @ManagedAttribute
    public boolean isFlag() {
        return flag;
    }

    @ManagedAttribute
    public void setFlag(boolean flag) {
        this.flag = flag;
        if(!flag){
            log.info("flag set to false. Lets do something else.");
        }
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
