package com.jci.tofs.sba;

import com.codahale.metrics.MetricRegistry;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.dropwizard.DropwizardExports;
import io.prometheus.client.hotspot.MemoryPoolsExports;
import io.prometheus.client.hotspot.StandardExports;
import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@EnablePrometheusEndpoint
public class PrometheusConfiguration {

    private MetricRegistry dropWizardMetricRegistry;

    @Autowired
    public PrometheusConfiguration(MetricRegistry dropWizardMetricRegistry) {
        this.dropWizardMetricRegistry = dropWizardMetricRegistry;
    }

    @PostConstruct
    public void registerPrometheusCollectors() {
        CollectorRegistry.defaultRegistry.clear();
        new StandardExports().register();
        new MemoryPoolsExports().register();
        new DropwizardExports(dropWizardMetricRegistry).register();
    }
}
