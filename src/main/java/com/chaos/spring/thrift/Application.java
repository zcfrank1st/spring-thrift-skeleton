package com.chaos.spring.thrift;

import com.chaos.spring.thrift.config.CacheConfig;
import com.chaos.spring.thrift.config.DbConfig;
import com.chaos.spring.thrift.config.ApplicationConfig;
import com.chaos.spring.thrift.config.MqConfig;
import com.chaos.spring.thrift.define.gen.Demo;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by zcfrank1st on 27/04/2017.
 */
@Configuration
@Import({ApplicationConfig.class, CacheConfig.class, DbConfig.class, MqConfig.class})
@ComponentScan
public class Application {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);
        Demo.Processor processor = (Demo.Processor) context.getBean("processor");
        try {

            TNonblockingServerTransport serverTransport = new TNonblockingServerSocket(9090);

            TNonblockingServer.Args tnbArgs = new TNonblockingServer.Args(serverTransport);
            tnbArgs.processor(processor);
            tnbArgs.transportFactory(new TFramedTransport.Factory());
            tnbArgs.protocolFactory(new TCompactProtocol.Factory());

            TServer server = new TNonblockingServer(tnbArgs);
            System.out.println("Starting the simple server...");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
