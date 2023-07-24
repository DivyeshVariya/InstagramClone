package com.postsmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PostsManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostsManagerApplication.class, args);
	}

}
