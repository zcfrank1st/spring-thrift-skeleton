import com.chaos.spring.thrift.define.gen.Demo;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.*;

import java.io.IOException;

/**
 * Created by zcfrank1st on 27/04/2017.
 */
public class Client {
    public static void main(String[] args) throws IOException, TException {
        TTransport transport = new TFramedTransport(new TSocket("localhost",
                9090, 3000));
        // 协议要和服务端一致
        TProtocol protocol = new TCompactProtocol(transport);
        Demo.Client client = new Demo.Client(protocol);
        transport.open();

        client.helloworld();

        transport.close();
    }
}
