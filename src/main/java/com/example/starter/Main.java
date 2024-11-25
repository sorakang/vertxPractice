package com.example.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

public class Main extends AbstractVerticle {
  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new Main());
  }

  @Override
  public void start() {
    vertx.createHttpServer()
      .requestHandler(req -> req.response().end("Hello World!"))
      .listen(8080, res -> {
        if (res.succeeded()) {
          System.out.println("Server is now listening to port 8080!");
        } else {
          System.out.println("Failed to bind: " + res.cause());
        }
      });
  }

  @Override
  public void stop() {
    System.out.println("Shutting down the server!");
  }
}