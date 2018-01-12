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

    public static double getProcessCpuLoad() throws Exception {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = ObjectName.getInstance("java.lang:type=OperatingSystem");
        AttributeList list = mbs.getAttributes(name, new String[]{"ProcessCpuLoad"});

        if (list.isEmpty()) return Double.NaN;

        Attribute att = (Attribute) list.get(0);
        Double value = (Double) att.getValue();

        // usually takes a couple of seconds before we get real values
        if (value == -1.0) return Double.NaN;
        // returns a percentage value with 1 decimal point precision
        return ((int) (value * 1000) / 10.0);
    }

}
