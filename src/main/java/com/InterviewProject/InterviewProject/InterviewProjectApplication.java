package com.InterviewProject.InterviewProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.InterviewProject")
@EntityScan(basePackages = {
		"com.InterviewProject.InterviewProject.model"
})
public class InterviewProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewProjectApplication.class, args);
	}
}
