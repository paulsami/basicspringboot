package com.bootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class AuditStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditStoreApplication.class, args);
	}

	@StreamListener(target = Sink.INPUT)
	public void processAuditInfo(String product) {
		System.out.println("Get the product data  Client " + product);
	}
}
