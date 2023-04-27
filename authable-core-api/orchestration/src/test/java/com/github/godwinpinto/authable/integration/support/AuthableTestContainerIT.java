package com.github.godwinpinto.authable.integration.support;

import org.testcontainers.containers.MySQLContainer;

public class AuthableTestContainerIT extends MySQLContainer<AuthableTestContainerIT> {
  private static final String IMAGE_VERSION = "mysql:8.0.33-debian";

  private static AuthableTestContainerIT container;

  private AuthableTestContainerIT() {
    super(IMAGE_VERSION);
  }

  public static AuthableTestContainerIT getInstance() {
    System.out.println("TEST CONTAINER LOADING");
    if (container == null) {
      container = new AuthableTestContainerIT().withInitScript("scripts.sql");
    }
    return container;
  }

  @Override
  public void start() {
    super.start();
    System.out.println("TEST CONTAINER STARTING");
    System.setProperty("DB_URL", container.getJdbcUrl());
    System.setProperty("DB_USERNAME", container.getUsername());
    System.setProperty("DB_PASSWORD", container.getPassword());
  }

  @Override
  public void stop() {
    //do nothing, JVM handles shut down
  }

}
