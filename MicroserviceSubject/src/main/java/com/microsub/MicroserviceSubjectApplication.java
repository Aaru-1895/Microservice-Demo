package com.microsub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker
public class MicroserviceSubjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceSubjectApplication.class, args);
		System.out.println("subject calling....");
		
	}
	
	
	  @Bean 
		/* @LoadBalanced */ 
	  public RestTemplate getrestRestTemplate() { 
		 return new RestTemplate();
	  }
	 

}
