package org.allforone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:database.properties")
public abstract class DatabaseConfig {
    @Autowired
    Environment env;

    public abstract DataSource dataSource() throws ClassNotFoundException;
    public abstract LocalContainerEntityManagerFactoryBean entityManagerFactory() throws ClassNotFoundException;

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }

    public Properties getJpaProperties() {
        Properties jpaProperties = new Properties();

        jpaProperties.setProperty("hibernate.ddl-auto", "true");
        jpaProperties.setProperty("hibernate.format_sql", env.getProperty("jpa.hibernate.format_sql"));
        jpaProperties.setProperty("hibernate.use_sql_comments", env.getProperty("jpa.hibernate.use_sql_comments"));
        jpaProperties.setProperty("hibernate.physical_naming_strategy", env.getProperty("jpa.hibernate.physical_naming_strategy"));
        return jpaProperties;
    }

    public LocalContainerEntityManagerFactoryBean getLocalContainerEntityManagerFactoryBean(HibernateJpaVendorAdapter vendorAdapter) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("org.allforone.spring.domain");
        factory.setJpaProperties(getJpaProperties());
        return factory;
    }
}