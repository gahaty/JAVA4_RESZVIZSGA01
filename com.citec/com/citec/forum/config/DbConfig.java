package com.citec.forum.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.citec.forum")
@PropertySource("classpath:application.properties")
public class DbConfig {

	@Value("${database.url}")
	private String databaseURL;

	@Value("${database.user}")
	private String userName;

	@Value("${database.password}")
	private String password;
	
	@Value("${database.driver}")
	private String driverClass;

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

	private DataSource dataSource() {
		DriverManagerDataSource manager = new DriverManagerDataSource();
		manager.setDriverClassName(driverClass);
		manager.setUrl(databaseURL);
		manager.setPassword(password);
		manager.setUsername(userName);

		return manager;
	}
}
