package com.springapps.azure;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.cloud.autoconfigure.RefreshEndpointAutoConfiguration;
import org.springframework.cloud.endpoint.RefreshEndpoint;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

@Component
@AutoConfigureAfter({RefreshAutoConfiguration.class, RefreshEndpointAutoConfiguration.class})
@EnableScheduling
public class RefreshConfig implements SchedulingConfigurer {
    @Value("${spring.cloud.config.refresh-interval:60}")
    private long refreshInterval;
    @Value("${spring.cloud.config.auto-refresh:true}")
    private boolean autoRefresh;
    private RefreshEndpoint refreshEndpoint;
    public RefreshConfig(RefreshEndpoint refreshEndpoint) {
        this.refreshEndpoint = refreshEndpoint;
    }
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        // set minimal refresh interval to 5 seconds
        refreshInterval = Math.max(refreshInterval, 5);
        // scheduledTaskRegistrar.addFixedRateTask(() -> refreshEndpoint.refresh(), Duration.ofMillis(refreshInterval * 1000));
        scheduledTaskRegistrar.addFixedRateTask(() -> refreshEndpoint.refresh(), refreshInterval * 1000);
    }
}