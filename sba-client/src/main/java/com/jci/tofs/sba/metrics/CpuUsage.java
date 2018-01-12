package com.jci.tofs.sba.metrics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

@Configuration
public class CpuUsage {

    private GaugeService gaugeService ;

    @Autowired
    public CpuUsage(GaugeService gaugeService){
        this.gaugeService = gaugeService;
    }

    @PostConstruct
    public void startMeasuring() {
        new Thread(() -> {
            try {
                gaugeService.submit("process.cpu.load", getProcessCpuLoad());
                Thread.sleep(2000);   //measure every 2sec.
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static double getProcessCpuLoad() {
        return ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();

    }

}
