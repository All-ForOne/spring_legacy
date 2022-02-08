package org.allforone.config.db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@Profile("test")
@EnableJpaRepositories
@EnableTransactionManagement
public class H2Config extends DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.H2)
                .setScriptEncoding("UTF-8")
                .addScripts("classpath:/sql/create.sql", "classpath:/sql/insert.sql")
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setDatabase(Database.H2);
        vendorAdapter.setDatabasePlatform(env.getProperty("jpa.test.database-platform"));
        vendorAdapter.setShowSql(Boolean.parseBoolean(env.getProperty("jpa.show-sql")));

        LocalContainerEntityManagerFactoryBean factory = getLocalContainerEntityManagerFactoryBean(vendorAdapter);
        factory.setDataSource(dataSource());
        return factory;
    }
}
