package com.test.ws_capture_trafic.capture;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.ws_capture_trafic.aws.SqsProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PayloadCaptureService {

    private final SqsProducer sqsProducer;
    private final ObjectMapper objectMapper;

    @Async
    public void capture(PayloadCapture capture) {

        try {

            String json =
                    objectMapper.writeValueAsString(capture);

            sqsProducer.send(json);

            System.out.println("Payload envoyé à SQS");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
