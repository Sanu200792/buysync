package com.buysync.buysynccore.config;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!test")
public class FlywayConfiguration {

    @Value("${spring.datasource.url}")
    private String databaseUrl;
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public Flyway flyway(){
        FluentConfiguration configure = Flyway.configure().dataSource(databaseUrl,userName,password);
        Flyway flyway = new Flyway(configure);
        flyway.migrate();
        return flyway;
    }
}
