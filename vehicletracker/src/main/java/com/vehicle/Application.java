package com.vehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.vehicle.helper.RuleHelper;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		RuleHelper.loadRules();
		SpringApplication app = new SpringApplication(Application.class);
		app.run();
	}
}
