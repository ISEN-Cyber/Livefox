package com.livefox.video.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("mes-configs")
public class ApplicationPropertiesConfigurations {
    private int limitDeVideos;

    public int getLimitDeVideos() {
        return limitDeVideos;
    }

    public void setLimitDeVideos(int limitDeVideos) {
        this.limitDeVideos = limitDeVideos;
    }
}
