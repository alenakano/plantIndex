package com.project.nakano.plantindex.spring.config;

import java.util.HashMap;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
    basePackages = {"com.project.nakano.plantindex.jpa","com.project.nakano.plantindex.auth" },
    entityManagerFactoryRef = "jpaEntityManager",
    transactionManagerRef = "jpaTransactionManager")
public class PersistenceJpaConfiguration {

  private static final String DIALECT = "org.hibernate.dialect.MySQL8Dialect";
  private static final String DDL = "update";

  @Value("${spring.jpa.properties.hibernate.format_sql}")
  private String format;

  @Value("${spring.jpa.show-sql}")
  private String showSql;

  @Primary
  @Bean(name = "jpaDataSource")
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource jpaDataSource() {
    return DataSourceBuilder.create().build();
  }

  /**
   * Configuração do EntityManager da Base de dados JPA.\
   *
   * @return LocalContainerEntityManagerFactoryBean
   */
  @Primary
  @Bean
  public LocalContainerEntityManagerFactoryBean jpaEntityManager() {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(jpaDataSource());
    em.setPackagesToScan(new String[] {"com.project.nakano.plantindex.jpa.model", "com.project.nakano.plantindex.auth"});
    
    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);
    HashMap<String, Object> properties = new HashMap<>();
    properties.put("hibernate.dialect", DIALECT);
    properties.put("hibernate.hbm2ddl.auto", DDL);
    properties.put("hibernate.format_sql", format);
    properties.put("hibernate.show_sql", showSql);
    em.setJpaPropertyMap(properties);
    
    return em;
  }
  
  /**
   * Configuração do TransactionManager da Base de dados JPA.\
   *
   * @return PlatformTransactionManager
   */
  @Primary
  @Bean
  public PlatformTransactionManager jpaTransactionManager() {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(jpaEntityManager().getObject());
    return transactionManager;
  }    
}

