package com.mvarone.appmeteo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.mvarone.appmeteo.util.elastic.log")
public class AppmeteoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppmeteoApplication.class, args);
	}

}
