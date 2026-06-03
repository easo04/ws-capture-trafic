package com.test.ws_capture_trafic.controller;

import com.test.ws_capture_trafic.capture.PayloadCapture;
import com.test.ws_capture_trafic.capture.PayloadCaptureService;
import com.test.ws_capture_trafic.config.CaptureProperties;
import com.test.ws_capture_trafic.model.PolicyDetailsResponse;
import com.test.ws_capture_trafic.model.PolicyResponse;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class PolicyController {
    private final PayloadCaptureService captureService;
    private final CaptureProperties captureProperties;

    public PolicyController(
            PayloadCaptureService captureService, CaptureProperties captureProperties) {
        this.captureService = captureService;
        this.captureProperties = captureProperties;
    }

    @GetMapping("/policy")
    public PolicyDetailsResponse getPolicy(
            @RequestParam String policyNumber, @RequestHeader Map<String,String> headers) {

        if(captureProperties.activate()){
            captureService.capture(
                    new PayloadCapture(
                            UUID.randomUUID().toString(),
                            Instant.now(),
                            "policy",
                            "api/policy",
                            "GET",
                            "policyNumber=" + policyNumber,
                            headers,
                            ""
                    ));
        }


        return new PolicyDetailsResponse(
                policyNumber,
                "Edgar Silvera",
                500
        );
    }

    @PostMapping("/policy")
    public PolicyResponse createPolicy(
            @RequestBody String payload,
            @RequestHeader Map<String,String> headers) {

        if(captureProperties.activate()){
            captureService.capture(
                    new PayloadCapture(
                            UUID.randomUUID().toString(),
                            Instant.now(),
                            "policy",
                            "api/policy",
                            "POST",
                            "",
                            headers,
                            payload));
        }


        return new PolicyResponse(5, 500);
    }

}
