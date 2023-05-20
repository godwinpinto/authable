package com.github.godwinpinto.authable.examples.verticles;

import static io.vertx.json.schema.common.dsl.Schemas.objectSchema;
import static io.vertx.json.schema.common.dsl.Schemas.stringSchema;

import com.github.godwinpinto.authable.examples.utils.ApplicationConstants;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.CorsHandler;
import io.vertx.ext.web.handler.LoggerHandler;
import io.vertx.ext.web.handler.SessionHandler;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.sstore.LocalSessionStore;
import io.vertx.ext.web.sstore.SessionStore;
import io.vertx.ext.web.validation.BodyProcessorException;
import io.vertx.ext.web.validation.ParameterProcessorException;
import io.vertx.ext.web.validation.RequestParameters;
import io.vertx.ext.web.validation.RequestPredicate;
import io.vertx.ext.web.validation.RequestPredicateException;
import io.vertx.ext.web.validation.ValidationHandler;
import io.vertx.ext.web.validation.builder.Bodies;
import io.vertx.ext.web.validation.builder.ValidationHandlerBuilder;
import io.vertx.json.schema.Draft;
import io.vertx.json.schema.JsonSchemaOptions;
import io.vertx.json.schema.SchemaParser;
import io.vertx.json.schema.SchemaRouter;
import io.vertx.json.schema.SchemaRouterOptions;
import io.vertx.json.schema.common.dsl.ObjectSchemaBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebVerticle extends AbstractVerticle {

  private static final Logger logger = LoggerFactory.getLogger(WebVerticle.class);

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    configureRouter()
      .compose(this::startHttpServer)
      .onComplete(ar -> {
        if (ar.failed()) {
          logger.info("Failed to start WebVerticle");
          startPromise.fail(ar.cause());
        } else {
          logger.info("WebVerticle Started");
          startPromise.complete();
        }
      });
  }

  Future<Router> configureRouter() {
    Router router = Router.router(vertx);
    SessionStore store = LocalSessionStore.create(vertx);
    router.route().handler(LoggerHandler.create());
    router.route().consumes("application/json");
    router.route().handler(SessionHandler.create(store));
    router.route().handler(CorsHandler.create().addRelativeOrigin(".*."));
    router.post("/api/v1/generate-qr").handler(BodyHandler.create())
      .handler(this::qrGenerateHandler);
    router.post("/api/v1/verify").handler(BodyHandler.create())
      .handler(tOtpRequestValidationHandler())
      .handler(this::verifyTotpHandler);
    router.route().handler(StaticHandler.create(ApplicationConstants.WEB_DIRECTORY));
    router.route().last().handler(this::notFound);
    Handler<RoutingContext> errorHandlerFunction = this::failureHandler;
    router.errorHandler(400, errorHandlerFunction);
    return Future.<Router>succeededFuture(router);
  }

  Future<Void> startHttpServer(Router router) {
    JsonObject http = config().getJsonObject("http");
    int httpPort = http.getInteger("port");
    HttpServer server = vertx.createHttpServer().requestHandler(router);
    return Future.<HttpServer>future(promise -> server.listen(httpPort, promise)).mapEmpty();
  }

  private void failureHandler(RoutingContext routingContext) {
    logger.error(routingContext.failure().getMessage());
    if (routingContext.failure() instanceof ParameterProcessorException parameterProcessorException) {
      customErrorMessage(routingContext, "Required fields are missing");
    } else if (routingContext.failure() instanceof BodyProcessorException bodyProcessorException) {
      customErrorMessage(routingContext, "Required fields are missing");
    } else if (routingContext.failure() instanceof RequestPredicateException requestPredicateException) {
      customErrorMessage(routingContext, "Required fields are missing");
    } else {
      serverError(routingContext);
    }
  }

  protected void notFound(RoutingContext context) {
    context.response().setStatusCode(404)
      .putHeader("content-type", "application/json")
      .end(new JsonObject().put("message", "not_found").encodePrettily());
  }

  protected void serverError(RoutingContext context) {
    context.response().setStatusCode(500)
      .putHeader("content-type", "application/json")
      .end(new JsonObject().put("message", "server_error").encodePrettily());
  }

  protected void customErrorMessage(RoutingContext context, String message) {
    context.response().setStatusCode(500)
      .putHeader("content-type", "application/json")
      .end(new JsonObject().put("message", message).encodePrettily());
  }

  void qrGenerateHandler(RoutingContext ctx) {
    vertx.eventBus().request(ApplicationConstants.TOTP_QR_EVENT_BUS_ADD, "", reply -> {
      ctx.request().response().end((String) reply.result().body());
    });
  }

  void verifyTotpHandler(RoutingContext ctx) {
    RequestParameters parameters = ctx.get(ValidationHandler.REQUEST_CONTEXT_KEY);
    JsonObject jsonObject = parameters.body().getJsonObject();
    vertx.eventBus().request(ApplicationConstants.TOTP_VERIFY_EVENT_BUS_ADD, jsonObject, reply -> {
      ctx.request().response().end((String) reply.result().body());
    });
  }


  ValidationHandler tOtpRequestValidationHandler() {
    SchemaParser parser = SchemaParser.createDraft7SchemaParser(
      SchemaRouter.create(vertx, new SchemaRouterOptions())
    );
    JsonSchemaOptions x = new JsonSchemaOptions().setDraft(Draft.DRAFT7);
    ObjectSchemaBuilder bodySchemaBuilderVerify = objectSchema()
      .requiredProperty("userId", stringSchema())
      .requiredProperty("otp", stringSchema());
    return ValidationHandlerBuilder.create(parser)
      .predicate(RequestPredicate.BODY_REQUIRED)
      .body(Bodies.json(bodySchemaBuilderVerify))
      .build();
  }

}
