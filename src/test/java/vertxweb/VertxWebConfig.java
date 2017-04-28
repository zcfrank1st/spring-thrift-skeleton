package vertxweb;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zcfrank1st on 28/04/2017.
 */
@Configuration
public class VertxWebConfig {
    @Bean
    Vertx vertx() {
        return Vertx.vertx();
    }

    @Bean
    HttpServer server() {
        return vertx().createHttpServer();
    }

    @Bean
    Router router() {
        return Router.router(vertx());
    }
}
