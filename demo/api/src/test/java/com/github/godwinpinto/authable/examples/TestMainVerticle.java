package com.github.godwinpinto.authable.examples;

import io.vertx.core.Vertx;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

//TODO
@ExtendWith(VertxExtension.class)
public class TestMainVerticle {

  //TODO
  @BeforeEach
  void deploy_verticle(Vertx vertx, VertxTestContext testContext) {
    testContext.completeNow();
    //vertx.deployVerticle(new MainVerticle(), testContext.succeeding(id -> testContext.completeNow()));
  }

  //TODO
  @Test
  void verticle_deployed(Vertx vertx, VertxTestContext testContext) throws Throwable {
    testContext.completeNow();
  }
}
