package com.project.nakano.plantindex.spring.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
  basePackages = "com.project.nakano.plantindex.jpa",
  entityManagerFactoryRef = "jpaEntityManager",
  transactionManagerRef = "jpaTransactionManager")
public class PersistenceJpaConfiguration {
	
	private static final String DIALECT = "org.hibernate.dialect.MySQL8Dialect";
	private static final String DDL = "update";
	private static final String FORMAT = "true";
	private static final String SHOWSQL = "true";
	
    @Primary
    @Bean(name="jpaDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource jpaDataSource() {
    	return DataSourceBuilder.create().build();
    }
  
    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean jpaEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(jpaDataSource());
        em.setPackagesToScan(new String[] { "com.project.nakano.plantindex.jpa.model" });

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", DIALECT);
        properties.put("hibernate.hbm2ddl.auto", DDL);
        properties.put("hibernate.format_sql", FORMAT);
        properties.put("hibernate.show_sql", SHOWSQL);
        em.setJpaPropertyMap(properties);

        return em;
    }
    
    @Primary
    @Bean
    public PlatformTransactionManager jpaTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(jpaEntityManager().getObject());
        return transactionManager;
    }

    
}

