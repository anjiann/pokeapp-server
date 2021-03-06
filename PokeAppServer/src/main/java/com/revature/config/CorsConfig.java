package com.revature.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		registry.addMapping("/**") // all endpoints in the api
        .allowedOrigins("http://localhost:1234", "http://localhost:3000", "http://ec2-3-96-46-240.ca-central-1.compute.amazonaws.com","http://192.168.2.51" ) // YOU MIGHT HAVE TO ADD OR CHANGE
        .allowedMethods("PUT", "DELETE", "GET", "OPTIONS", "POST", "PATCH")
        .allowedHeaders("header1", "Content-Type", "Authorization", "auth", "user", "favorite", "team" );//YOU MIGHT HAVE TO ADD HEADERS
       //.exposedHeaders("header1", "header2")
   // .allowCredentials(true);
	}
	
	
}
