package com;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class ApiConfig implements WebMvcConfigurer{
	
	public void addCORSMapping(CorsRegistry corsRegistry)
	{
		corsRegistry.addMapping("/**").allowedMethods("GET","POST","PUT","DELETE");
	}

}
