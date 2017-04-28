import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import org.apache.thrift.TException;

/**
 * Created by zcfrank1st on 28/04/2017.
 */
public class VertxServer {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        HttpServer server = vertx.createHttpServer();


        server.requestHandler(request -> {

            // This handler gets called for each request that arrives on the server
            HttpServerResponse response = request.response();
            response.putHeader("content-type", "text/plain");

            ThriftClient thrift = new ThriftClient();
            try {
                thrift.client().helloworld();
                thrift.close();
            } catch (TException e) {
                e.printStackTrace();
            }
            // Write to the response and end it
            response.end("Hello World!");
        });

        server.listen(8080);
    }
}
