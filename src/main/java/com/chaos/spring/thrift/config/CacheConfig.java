package com.chaos.spring.thrift.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import redis.clients.jedis.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zcfrank1st on 27/04/2017.
 */
@Configuration
@PropertySource("classpath:${profile:dev}/app.properties")
public class CacheConfig {
    private final Environment env;

    @Autowired
    public CacheConfig(Environment env) {
        this.env = env;
    }

    @Bean(destroyMethod = "close")
    JedisCluster jedisCluster() {
        String cluster = env.getProperty("cache.redis.cluster");
        List<String> ipPortList = Arrays.asList(cluster.split(","));
        Set<HostAndPort> nodes = new HashSet<>();
        for (String ipPort : ipPortList) {
            String[] ipPortArray = ipPort.split(":");
            nodes.add(new HostAndPort(ipPortArray[0], Integer.parseInt(ipPortArray[1])));
        }
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(200);
        config.setMaxIdle(20);
        config.setMinIdle(5);
        config.setMaxWaitMillis(2000);
        return new JedisCluster(nodes, 2000, 10, config);
    }

//    @Bean(destroyMethod = "close")
//    JedisPool pikaClientPool() {
//        String[] ipPort = env.getProperty("cache.pika").split(":");
//        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
//        config.setMaxTotal(200);
//        config.setMaxIdle(20);
//        config.setMinIdle(5);
//        config.setMaxWaitMillis(2000);
//        return new JedisPool(config, ipPort[0], Integer.parseInt(ipPort[1]), 2000);
//    }
}
