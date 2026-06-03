package com.test.ws_capture_trafic.aws;
import com.test.ws_capture_trafic.config.CaptureProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@Component
@RequiredArgsConstructor
public class SqsProducer {

    private final SqsClient sqsClient;
    private final CaptureProperties captureProperties;

    public void send(String message) {

        SendMessageRequest request =
                SendMessageRequest.builder()
                        .queueUrl(captureProperties.queueUrl())
                        .messageBody(message)
                        .build();

        sqsClient.sendMessage(request);
    }
}
