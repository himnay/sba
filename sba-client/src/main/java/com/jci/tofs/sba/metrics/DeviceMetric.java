package com.jci.tofs.sba.metrics;

import com.codahale.metrics.Counter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeviceMetric {
    private Meter meter;
    private Timer timer;
    private Counter counter;

    @Autowired
    public DeviceMetric(MetricRegistry metricRegistry){
        this.meter = metricRegistry.meter("jci.tofs.device.update.meter");
        this.timer = metricRegistry.timer("jci.tofs.device.update.time");
        this.counter = metricRegistry.counter("jci.tofs.device.update.count");
    }

    public Meter getMeter() {
        return meter;
    }

    public Timer getTimer() {
        return timer;
    }

    public Counter getCounter() {
        return counter;
    }

}
