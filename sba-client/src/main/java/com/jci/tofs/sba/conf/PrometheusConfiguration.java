package com.jci.tofs.sba.conf;

import com.codahale.metrics.MetricRegistry;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.dropwizard.DropwizardExports;
import io.prometheus.client.hotspot.DefaultExports;
import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@EnablePrometheusEndpoint
public class PrometheusConfiguration {

    private MetricRegistry metricRegistry;
//    private HealthCheckRegistry healthCheckRegistry = new HealthCheckRegistry();
    private DefaultExports defaultExports = new DefaultExports();

    @Autowired
    public PrometheusConfiguration(MetricRegistry metricRegistry) {
        this.metricRegistry = metricRegistry;
    }

    @PostConstruct
    public void registerPrometheusCollectors() {
        CollectorRegistry.defaultRegistry.clear();

        // register all collector. can be customized as per need. The same can be done by @EnableSpringBootMetricsCollector
        // defaultExports.initialize();
        new DropwizardExports(metricRegistry).register();
    }
}
