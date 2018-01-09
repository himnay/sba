package com.jci.tofs.sba;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {

    private Meter meter;
    private Timer timer;

    @Autowired
    public BusinessService(MetricRegistry metricRegistry){
        this.meter = metricRegistry.meter("jci.tofs.device.update.count");
        this.timer = metricRegistry.timer("jci.tofs.device.update.time");
    }

    public void updateDevice(){
        Timer.Context time = timer.time();
        meter.mark();
        time.stop();
    }

}
