package vertxweb;

import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by zcfrank1st on 28/04/2017.
 */
@Configuration
@ComponentScan
@Import(VertxWebConfig.class)
public class VertxWeb {
    public static void main(String[] args) {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(VertxWeb.class);
        HttpServer server = appContext.getBean(HttpServer.class);
        Router router = appContext.getBean(Router.class);

        VertxService service = appContext.getBean(VertxService.class);

        router.get("/helloworld").handler(context -> {
            HttpServerResponse response = context.response();

            response.putHeader("content-type", "text/plain");
            response.end(service.hello());
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
