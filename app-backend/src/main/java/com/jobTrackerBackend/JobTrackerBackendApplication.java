package com.jobTrackerBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.jobTrackerBackend.repository.JobPostRepository;


@SpringBootApplication
@EnableMongoRepositories
public class JobTrackerBackendApplication implements CommandLineRunner{
	@Autowired
	JobPostRepository jpRepo;
	

	public static void main(String[] args) {
		SpringApplication.run(JobTrackerBackendApplication.class, args);
	}

	public void run(String... args) {
	}

}
