package com.github.godwinpinto.authable.examples;

import com.github.godwinpinto.authable.examples.config.ConfigHelper;
import com.github.godwinpinto.authable.examples.verticles.ApiIntegrationVerticle;
import com.github.godwinpinto.authable.examples.verticles.RealmUserAuthVerticle;
import com.github.godwinpinto.authable.examples.verticles.WebVerticle;
import io.vertx.config.ConfigChange;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.CompositeFuture;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainVerticle extends AbstractVerticle {

  private static final Logger logger = LoggerFactory.getLogger(MainVerticle.class);

  private final JsonObject currentConfig = new JsonObject();

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    ConfigHelper configHelper = new ConfigHelper();
    configHelper.initConfig(vertx, config(), this)
      .compose(this::storeConfig)
      .compose(this::deployOtherVerticles)
      .onComplete(ar -> {
        if (ar.failed()) {
          logger.info("Failed to launch MainVerticle");
          startPromise.fail(ar.cause());
        } else {
          logger.info("Started MainVerticle");
          startPromise.complete();
        }
      });
  }

  Future<Void> storeConfig(JsonObject config) {
    currentConfig.mergeIn(config);
    return Future.succeededFuture();
  }

  public void loadNewConfig(ConfigChange change) {
    logger.info("loaded again");
    this.currentConfig.mergeIn(change.getNewConfiguration());
  }


  Future<Void> deployOtherVerticles(Void unUsed) {
    DeploymentOptions opts = new DeploymentOptions().setConfig(currentConfig);
    DeploymentOptions optsWorker = new DeploymentOptions().setConfig(currentConfig).setWorker(true)
      .setWorkerPoolSize(20);

    Future<String> webVerticle = Future.future(
      promise -> vertx.deployVerticle(new WebVerticle(), opts, promise));
    Future<String> apiIntegrationVerticle = Future.future(
      promise -> vertx.deployVerticle(new ApiIntegrationVerticle(), optsWorker, promise));
    Future<String> realmUserAuthVerticle = Future.future(
      promise -> vertx.deployVerticle(new RealmUserAuthVerticle(), opts, promise));

    return CompositeFuture.all(webVerticle, apiIntegrationVerticle
      , realmUserAuthVerticle
    ).mapEmpty();
  }
}
