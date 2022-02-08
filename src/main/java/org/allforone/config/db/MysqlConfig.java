package org.allforone.config.db;

import com.mysql.cj.jdbc.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@Profile("default")
@EnableJpaRepositories(basePackages = "org.allforone.spring.*")
@EnableTransactionManagement
public class MysqlConfig extends DatabaseConfig {

    @Bean
    public DataSource dataSource() throws ClassNotFoundException {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

        dataSource.setDriverClass((Class<Driver>) Class.forName(env.getProperty("datasource.driver-class-name")));
        dataSource.setUrl(env.getProperty("datasource.url"));
        dataSource.setUsername(env.getProperty("datasource.username"));
        dataSource.setPassword(env.getProperty("datasource.password"));

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws ClassNotFoundException {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(Boolean.parseBoolean(env.getProperty("jpa.generate-ddl")));
        vendorAdapter.setDatabase(Database.MYSQL);
        vendorAdapter.setDatabasePlatform(env.getProperty("jpa.database-platform"));
        vendorAdapter.setShowSql(Boolean.parseBoolean(env.getProperty("jpa.show-sql")));

        LocalContainerEntityManagerFactoryBean factory = getLocalContainerEntityManagerFactoryBean(vendorAdapter);
        factory.setDataSource(dataSource());
        return factory;
    }

}