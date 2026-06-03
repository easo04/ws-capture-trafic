package com.test.ws_capture_trafic;

import com.test.ws_capture_trafic.config.CaptureProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableConfigurationProperties(CaptureProperties.class)
@EnableAsync
public class WsCaptureTraficApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsCaptureTraficApplication.class, args);
	}

}
