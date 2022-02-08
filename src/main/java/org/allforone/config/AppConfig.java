package org.allforone.config;

import org.allforone.config.db.DatabaseConfig;
import org.allforone.config.db.H2Config;
import org.allforone.config.db.MysqlConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({H2Config.class, MysqlConfig.class})
public class AppConfig {

    private final DatabaseConfig dataConfig;

    public AppConfig(DatabaseConfig dataConfig) {
        this.dataConfig = dataConfig;
    }
}
