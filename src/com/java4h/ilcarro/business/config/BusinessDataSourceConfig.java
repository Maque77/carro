package com.java4h.ilcarro.business.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.java4h.ilcarro",
entityManagerFactoryRef = "businessEntityManagerFactory",
transactionManagerRef= "businessTransactionManager")
public class BusinessDataSourceConfig {
		
	@Primary
	@Bean(name = "businessDataSourceProperties")//bean dobavlyaet v application context
	@ConfigurationProperties("business.datasource")//put, otkuda beret dannie bean
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}
	@Primary
	@Bean(name = "businessDataSource")
	public DataSource dataSource(@Qualifier("businessDataSourceProperties") DataSourceProperties dataSourceProperties) {
		return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}
	@Primary
	@Bean(name = "businessEntityManagerFactory") //poluchaet to, s chem budut rabotat entity manager
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			EntityManagerFactoryBuilder builder, @Qualifier("businessDataSource") DataSource businessDataSource) {
		return builder
				.dataSource(businessDataSource)
				.packages("com.java4h.ilcarro.business")//ukazivaet istochnik dannih
				.build();
	}
	@Primary
	@Bean(name = "businessTransactionManager") //
	public PlatformTransactionManager transactionManager(
			@Qualifier("businessEntityManagerFactory") EntityManagerFactory businessEntityManagerFactory) {
		return new JpaTransactionManager(businessEntityManagerFactory);
	}


}


