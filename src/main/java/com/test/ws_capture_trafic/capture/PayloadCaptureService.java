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

            long startTime = System.currentTimeMillis();

            String json =
                    objectMapper.writeValueAsString(capture);

            sqsProducer.send(json);

            long duration = System.currentTimeMillis() - startTime;

            System.out.println("Payload envoyé à SQS");
            System.out.println("Temps d'exécution de la capture: " + duration);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
