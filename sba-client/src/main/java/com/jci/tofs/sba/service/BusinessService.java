package com.jci.tofs.sba.service;

import com.codahale.metrics.Counter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {

    //private Meter meter;
    private Timer timer;
    private Counter counter;

    @Autowired
    public BusinessService(MetricRegistry metricRegistry){
        //this.meter = metricRegistry.meter("jci.tofs.device.update.count");
        this.timer = metricRegistry.timer("jci.tofs.device.update.time");
        this.counter = metricRegistry.counter("jci.tofs.device.update.count");
    }

    public void updateDevice(){
        Timer.Context time = timer.time();
        counter.inc();
        time.stop();
    }

}
