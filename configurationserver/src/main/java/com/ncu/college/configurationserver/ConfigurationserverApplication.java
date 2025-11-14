package com.ncu.college.configurationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigurationServer;

@SpringBootApplication
@EnableConfigurationServer
public class ConfigurationserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationserverApplication.class, args);
	}

}
