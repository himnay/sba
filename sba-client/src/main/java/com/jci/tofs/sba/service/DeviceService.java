package com.jci.tofs.sba.service;

import com.codahale.metrics.Timer;
import com.jci.tofs.sba.metrics.DeviceMetric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    private final DeviceMetric deviceMetric;

    @Autowired
    public DeviceService(DeviceMetric deviceMetric){
        this.deviceMetric = deviceMetric;
    }

    public void updateDevice(){
        Timer.Context time = deviceMetric.getTimer().time();
        deviceMetric.getCounter().inc();
        time.stop();
    }

}
