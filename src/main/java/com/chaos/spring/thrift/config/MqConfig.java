package com.chaos.spring.thrift.config;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by zcfrank1st on 27/04/2017.
 */
@Configuration
@PropertySource("classpath:${profile:dev}/app.properties")
public class MqConfig {
    private final Environment env;

    @Autowired
    public MqConfig(Environment env) {
        this.env = env;
    }

    @Bean(destroyMethod = "shutdown")
    DefaultMQProducer producer() throws MQClientException {
        DefaultMQProducer producer = new
                DefaultMQProducer("demo_producer");

        producer.setNamesrvAddr(env.getProperty("mq.nameserv"));
        producer.start();

        return producer;
    }

    @Bean(destroyMethod = "shutdown")
    DefaultMQPushConsumer consumer() throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("demo_consumer");

        consumer.setNamesrvAddr(env.getProperty("mq.nameserv"));
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        consumer.subscribe("DemoTopic", null);
        return consumer;
    }

}
