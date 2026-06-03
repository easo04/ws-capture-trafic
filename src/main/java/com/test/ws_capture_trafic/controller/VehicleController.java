package com.test.ws_capture_trafic.controller;

import com.test.ws_capture_trafic.capture.PayloadCapture;
import com.test.ws_capture_trafic.capture.PayloadCaptureService;
import com.test.ws_capture_trafic.model.VehicleResponse;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class VehicleController {
    private final PayloadCaptureService captureService;

    public VehicleController(
            PayloadCaptureService captureService) {
        this.captureService = captureService;
    }

    @GetMapping("/vehicle")
    public String test() {
        return "OK Vehicle";
    }

    @PostMapping("/vehicle")
    public VehicleResponse createPolicy(
            @RequestBody String payload, @RequestHeader Map<String,String> headers) {

        captureService.capture(
                new PayloadCapture(
                        UUID.randomUUID().toString(),
                        Instant.now(),
                        "vehicle",
                        "api/vehicle",
                        "POST",
                        "",
                        headers,
                        payload));

        return new VehicleResponse(5, 500);
    }
}
