package com.Ashutosh.web.CommunityProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories(basePackages= {"com.Ashutosh.web.CommunityProject.RepoHandler","com.Ashutosh.web.CommunityProject.test"})
public class CommunityProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommunityProjectApplication.class, args);
	}

}
