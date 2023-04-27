package com.github.godwinpinto.authable.integration.support;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

@TestConfiguration
public class TestContainerSetupIT {

  @Bean
  public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
    ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
    initializer.setConnectionFactory(connectionFactory);
    CompositeDatabasePopulator compositeDatabasePopulator = new CompositeDatabasePopulator();
    compositeDatabasePopulator.addPopulators(
        new ResourceDatabasePopulator(new ClassPathResource("scripts.sql")));
    initializer.setDatabasePopulator(compositeDatabasePopulator);
    return initializer;
  }
}
