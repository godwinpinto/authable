package com.github.godwinpinto.authable.examples.verticles;

import com.github.godwinpinto.authable.examples.utils.ApplicationConstants;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonObject;
import io.vertx.core.shareddata.AsyncMap;
import io.vertx.core.shareddata.SharedData;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;
import io.vertx.ext.web.client.predicate.ResponsePredicate;
import io.vertx.ext.web.codec.BodyCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RealmUserAuthVerticle extends AbstractVerticle {

  private static final Logger logger = LoggerFactory.getLogger(RealmUserAuthVerticle.class);

  JsonObject authProps;

  @Override
  public void start(Promise<Void> startPromise) {
    JsonObject coreConfig = config().getJsonObject("authable").getJsonObject("core");
    WebClientOptions webClientOptions = new WebClientOptions()
      .setUserAgent(ApplicationConstants.WEB_CLIENT_AGENT).setDefaultHost(coreConfig.getString("host"))
      .setDefaultPort(coreConfig.getInteger("port"))
      .setLogActivity(true);
    WebClient webClient = WebClient.create(vertx, webClientOptions);

    this.authProps = config().getJsonObject("authable").getJsonObject("auth");
    Long firstFetchTimeInterval = authProps.getLong("first_fetch_time");
    String authUserName = authProps.getString("realm_username");
    String authPassword = authProps.getString("realm_password");
    String authRealm = authProps.getString("realm_name");

    Handler<Promise<Void>> blockingCodeHandler = handler -> this.nextCall(webClient, authUserName, authPassword,
      authRealm);
    Handler<AsyncResult<Void>> authTimerHandler = result -> this.handleAuthCallResult(startPromise, result);
    vertx.executeBlocking(blockingCodeHandler, authTimerHandler);
    logger.info("RealmUserAuthentication Started");
  }

  void handleAuthCallResult(Promise<Void> start, AsyncResult<Void> result) {
    if (result.failed()) {
      start.fail(result.cause());
    } else {
      start.complete();
    }
  }


  void successTimerSet(Void unused, WebClient webClient, String userName, String password, String realmName) {
    Long refreshTime = authProps.getLong("refresh_time");
    Handler<Promise<Void>> blockingCodeHandler = handler -> this.nextCall(webClient, userName, password, realmName);
    vertx.setTimer(refreshTime, id -> {
      vertx.executeBlocking(blockingCodeHandler);
      logger.info("success timer called");
    });
  }

  void retryTimerSet(WebClient webClient, String userName, String password, String realmName) {
    Long retryTimeInterval = authProps.getLong("retry_time");
    Handler<Promise<Void>> blockingCodeHandler = handler -> this.nextCall(webClient, userName, password, realmName);
    vertx.setTimer(retryTimeInterval, id -> {
      vertx.executeBlocking(blockingCodeHandler);
      logger.info("Retry timer called");
    });
  }

  void nextCall(WebClient webClient, String userName, String password, String realmName) {
    callAuthService(webClient, userName, password, realmName)
      .onSuccess(unused -> successTimerSet(unused, webClient, userName, password, realmName))
      .onFailure(handler -> {
        logger.error("Failed call to auth", handler.getCause());
        retryTimerSet(webClient, userName, password, realmName);
      });
  }

  Future<Void> callAuthService(WebClient webClient, String userName, String password, String realmName) {
    Promise<Void> promise = Promise.promise();
    JsonObject requestObject = new JsonObject()
      .put("systemId", realmName)
      .put("userId", userName)
      .put("userSecret", password);
    webClient
      .post("/auth/login")
      .as(BodyCodec.jsonObject())
      .expect(ResponsePredicate.status(200))
      .sendJsonObject(requestObject)
      .onSuccess(res -> {
        logger.info("Authenticated successfully");
        JsonObject body = res.body();
        fetchAndUpdateSharedData(promise, body.getString("accessToken"));
      }).onFailure(throwable -> {
        logger.error("Error in Realm Authentication", throwable);
        promise.fail(throwable.getCause());
      });
    return promise.future();
  }

  void fetchAndUpdateSharedData(Promise<Void> promise, String accessToken) {
    SharedData sharedData = vertx.sharedData();
    sharedData.
      <String, String>getLocalAsyncMap(ApplicationConstants.SHARED_DATA_KEY_ACCESS_TOKEN)
      .onComplete(resMap -> {
        if (resMap.succeeded()) {
          // Local-only async map
          AsyncMap<String, String> map = resMap.result();
          map.put(ApplicationConstants.SHARED_DATA_KEY_ACCESS_TOKEN, accessToken).onComplete(resPut -> {
            if (resPut.succeeded()) {
              logger.debug("Access Token Updated in map");
              promise.complete();
            } else {
              logger.error("Access Token updating failed");
              promise.fail(resPut.cause());
            }
          });
        } else {
          logger.error("Unable to fetch Access Token from SharedData");
          promise.fail(resMap.cause());
        }
      });
  }

}
