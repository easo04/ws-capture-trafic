package com.test.ws_capture_trafic.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "capture")
public record CaptureProperties(
        String queueUrl,
        boolean activate
) {
}