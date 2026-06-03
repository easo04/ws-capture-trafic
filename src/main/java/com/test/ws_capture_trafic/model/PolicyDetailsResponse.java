package com.test.ws_capture_trafic.model;

public record PolicyDetailsResponse(
        String policyNumber,
        String customer,
        int score
) {
}