package com.project.nakano.plantindex.spring.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.project.nakano.plantindex")
public class PersistenceJdbcConfiguration {
	
	@Bean("jdbc-db")
	@ConfigurationProperties(prefix = "plantindexjdbc.second-datasource")
	DataSource jdbcDataSource() {
		return DataSourceBuilder.create().build();
	}
}
