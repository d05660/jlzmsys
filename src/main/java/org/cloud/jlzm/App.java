package org.cloud.jlzm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class App {
	
	private final static Logger logger = LoggerFactory.getLogger("o.c.y.Main");
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		logger.info("============= SpringBoot Start Success =============");
	}
	
}
