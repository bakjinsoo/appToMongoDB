package com.hackathon.appToMongoDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class AppToMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppToMongoDbApplication.class, args);
	}

}
