package org.camunda.consulting;

import io.camunda.zeebe.spring.client.EnableZeebeClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableZeebeClient
public class ProcessSolution {

	public static void main(String[] args) {
		SpringApplication.run(ProcessSolution.class, args);
	}
}
