package com.bloglike.appbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.bloglike.appbackend.model.JobPost;
import com.bloglike.appbackend.repository.JobPostRepository;


@SpringBootApplication
@EnableMongoRepositories
public class AppBackendApplication implements CommandLineRunner{
	@Autowired
	JobPostRepository jpRepo;

	public static void main(String[] args) {
		SpringApplication.run(AppBackendApplication.class, args);
	}

	public void run(String... args) {
	}

}
