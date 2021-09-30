/* SMARTSOFT 2021
 */

package org.springframework.samples.smartsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Smartsoft Spring Boot Application.
 *
 * @author Luis Urbina
 *
 */
@SpringBootApplication
public class SmartsoftApplication {

    public static void main(String[] args) {
	SpringApplication.run(SmartsoftApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
	return new WebMvcConfigurer() {
	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/products").allowedOrigins("*");
		registry.addMapping("/invoice").allowedOrigins("*");
		registry.addMapping("/invoice/*").allowedOrigins("*");
		registry.addMapping("/persons").allowedOrigins("*");
	    }
	};
    }

}
