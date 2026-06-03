package com.test.ws_capture_trafic.capture;

import java.time.Instant;
import java.util.Map;

public record PayloadCapture(
        String captureId,
        Instant timestamp,
        String serviceName,
        String endpoint,
        String method,
        String queryString,
        Map<String, String> headers,
        String payload
) {
}
