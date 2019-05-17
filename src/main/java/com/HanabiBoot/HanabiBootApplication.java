package com.HanabiBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import javax.activation.DataSource;

@SpringBootApplication
public class HanabiBootApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
//		ConfigurableApplicationContext context = SpringApplication.run(HanabiBootApplication.class, args);
//		DataSource dataSource = context.getBean(DataSource.class);
//		System.out.println(dataSource.getClass());
		SpringApplication.run(HanabiBootApplication.class, args);
	}
	@Override//为了打包springboot项目
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}
}
