package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
}

@RestController
class MyController{
	
	@Value("${eureka.instance.instance-id}")
	private String instanceId;
	
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello";
    }
    
    @RequestMapping(value="/instanceId", method = RequestMethod.GET)
    public String getInstanceId() {
    	return instanceId;
    }

}

