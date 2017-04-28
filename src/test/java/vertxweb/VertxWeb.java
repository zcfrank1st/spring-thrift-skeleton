package vertxweb;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

/**
 * Created by zcfrank1st on 28/04/2017.
 */
public class VertxWeb {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        HttpServer server = vertx.createHttpServer();
        Router router = Router.router(vertx);

        router.get("/helloworld").handler(context -> {
            HttpServerResponse response = context.response();

            response.putHeader("content-type", "text/plain");
            response.end("hello");
        });

        router.get("/helloworld1").handler(context -> {
            HttpServerResponse response = context.response();

            response.putHeader("content-type", "text/plain");
            response.end("hello1");
        });

        router.post("/helloworld2").consumes("*/json").handler(routingContext -> {
            // TODO use rxjava to combine data
            String body = routingContext.getBodyAsString("UTF-8");
            routingContext.response().end(body);
        });

        server.requestHandler(router::accept).listen(8080);
    }
}
