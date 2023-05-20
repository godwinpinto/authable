package com.github.godwinpinto.authable.examples.config;

import com.github.godwinpinto.authable.examples.MainVerticle;
import com.github.godwinpinto.authable.examples.utils.ApplicationConstants;
import io.vertx.config.ConfigRetriever;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

public class ConfigHelper {

  public Future<JsonObject> initConfig(final Vertx vertx, JsonObject config, MainVerticle mainVerticle) {
    ConfigRetrieverOptions opts = new ConfigRetrieverOptions()
      .addStore(initConfigFileWatcher())
      .addStore(initConfigCliWatcher(config));
    ConfigRetriever cfgRetriever = ConfigRetriever.create(vertx, opts);
    cfgRetriever.listen(mainVerticle::loadNewConfig);
    return Future.future(cfgRetriever::getConfig);
  }

  private ConfigStoreOptions initConfigFileWatcher() {
    return new ConfigStoreOptions().setType("file").setFormat("json")
      .setConfig(new JsonObject().put("path", ApplicationConstants.DEFAULT_CONFIG_FILE));
  }

  private ConfigStoreOptions initConfigCliWatcher(JsonObject config) {
    return new ConfigStoreOptions()
      .setType("json")
      .setConfig(config);
  }


}
