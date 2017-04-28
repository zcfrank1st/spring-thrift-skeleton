import com.chaos.spring.thrift.define.gen.Demo;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * Created by zcfrank1st on 27/04/2017.
 */
public class ThriftClient {
    private TTransport transport;

    public Demo.Client client() {
        try {
            transport = new TFramedTransport(new TSocket("localhost",
                    9090, 3000));
            // 协议要和服务端一致
            TProtocol protocol = new TCompactProtocol(transport);
            Demo.Client client = new Demo.Client(protocol);
            transport.open();

            return client;
        } catch (Exception e) {
            // TODO
            throw new RuntimeException("");
        }
    }

    public void close() {
        transport.close();
    }
}
