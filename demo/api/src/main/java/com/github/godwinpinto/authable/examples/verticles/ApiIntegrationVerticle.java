package com.github.godwinpinto.authable.examples.verticles;

import com.github.godwinpinto.authable.examples.utils.ApplicationConstants;
import com.github.godwinpinto.authable.examples.utils.ApplicationUtils;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;
import io.vertx.core.shareddata.AsyncMap;
import io.vertx.core.shareddata.SharedData;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;
import io.vertx.ext.web.codec.BodyCodec;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ApiIntegrationVerticle extends AbstractVerticle {

  private static final Logger logger = LoggerFactory.getLogger(ApiIntegrationVerticle.class);

  String verticleId = UUID.randomUUID().toString();
  private static String accessToken = "";
  WebClient webClient;

  @Override
  public void start() {

    vertx.setPeriodic(5000, id -> {
      vertx.executeBlocking(
        future -> {
          fetchAccessToken(id);
          future.complete();
        }, res -> {
        });
    });
    JsonObject coreConfig = config().getJsonObject("authable").getJsonObject("core");
    WebClientOptions webClientOptions = new WebClientOptions()
      .setUserAgent("Example/1.0.0").setDefaultHost(coreConfig.getString("host"))
      .setDefaultPort(coreConfig.getInteger("port"));
    webClient = WebClient.create(vertx, webClientOptions);

    /* Register consumer handlers for responding */
    vertx.eventBus().consumer(ApplicationConstants.TOTP_QR_EVENT_BUS_ADD).handler(this::generateQrForTOtp);
    vertx.eventBus().consumer(ApplicationConstants.TOTP_VERIFY_EVENT_BUS_ADD).handler(this::verifyTOtpHandler);
    logger.info("APIIntegrationVerticle Started");
  }

  private void generateQrForTOtp(Message<Object> msg) {

    String username = ApplicationUtils.generateRandomUserName();
    createTOtpRecord(username)
      .onComplete(ar -> {
        if (ar.succeeded()) {
          createQR(msg, username);
        } else {
          msg.reply(ar.cause().getMessage());
        }
      });
  }

  private void createQR(Message<Object> msg, String username) {
    webClient
      .post("/totp/generate-qr")
      .as(BodyCodec.jsonObject())
      .putHeader("Content-Type", "application/json")
      .putHeader("Authorization", "Bearer " + accessToken)
      .sendJsonObject(new JsonObject()
        .put("userId", username))
      .onSuccess(res -> {
        JsonObject body = res.body();
        body.put("username", username);
        msg.reply(body.toString());
      }).onFailure(throwable -> {
        logger.error("Error for {} {}", username, throwable.getCause(), throwable);
        msg.reply(getResponseObjectAsString("Something went wrong", throwable.getMessage()));
      });
  }

  Future<String> createTOtpRecord(String userId) {
    Promise<String> promise = Promise.promise();
    webClient
      .post("/totp/subscribe")
      .as(BodyCodec.jsonObject())
      .putHeader("Content-Type", "application/json")
      .putHeader("Authorization", "Bearer " + accessToken)
      .sendJsonObject(new JsonObject()
        .put("userId", userId))
      .onSuccess(res -> {
        if (res.statusCode() == 200) {
          promise.complete("OK");
        } else {
          JsonObject responseObject = res.body();
          promise.fail(responseObject.toString());
        }
      }).onFailure(throwable -> {
        promise.fail(throwable.getMessage());
        logger.error("Error for {} {}", userId, throwable.getCause(), throwable);
      });
    return promise.future();
  }

  private String getResponseObjectAsString(String message, String description) {
    JsonObject jsonObject = new JsonObject();
    jsonObject.put("status", "failed");
    jsonObject.put("message", message);
    jsonObject.put("description", description);
    return jsonObject.toString();
  }

  private void verifyTOtpHandler(Message<Object> msg) {
    JsonObject parameters = (JsonObject) msg.body();
    String username = parameters.getString("userId");
    logger.info("inside verify handler");
    webClient
      .post("/totp/verify")
      .as(BodyCodec.jsonObject())
      //.expect(ResponsePredicate.status(200))
      .putHeader("Content-Type", "application/json")
      .putHeader("Authorization", "Bearer " + accessToken)
      .sendJsonObject(parameters)
      .onSuccess(res -> {
        JsonObject body = res.body();
        body.put("status", "success");
        msg.reply(body.toString());
      }).onFailure(throwable -> {
        logger.error("Error for {} {}", username, throwable.getCause(), throwable);
        msg.reply(getResponseObjectAsString("Oops!!", throwable.getMessage()));
      });
  }

  void fetchAccessToken(long timerId) {
    final SharedData sharedData = vertx.sharedData();
    sharedData.
      <String, String>getLocalAsyncMap(ApplicationConstants.SHARED_DATA_KEY_ACCESS_TOKEN)
      .onComplete(resMap -> {
        if (resMap.succeeded()) {
          AsyncMap<String, String> map = resMap.result();
          map.get(ApplicationConstants.SHARED_DATA_KEY_ACCESS_TOKEN, stringAsyncResult -> {
            if (stringAsyncResult.succeeded()) {
              accessToken = stringAsyncResult.result();
              logger.info("Access Token found");
            } else {
              logger.error("No AccessToken Set", stringAsyncResult.cause());
            }
          });
        } else {
          logger.error("No Shared map found", resMap.cause());
        }
      });
  }
}
