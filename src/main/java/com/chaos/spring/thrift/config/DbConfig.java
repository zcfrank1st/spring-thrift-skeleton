package com.chaos.spring.thrift.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
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
@MapperScan("com.chaos.spring.thrift.module.db.mapper")
public class DbConfig {
    private final Environment env;

    @Autowired
    public DbConfig(Environment env) {
        this.env = env;
    }

    @Bean
    HikariConfig hikariConfig() {
        HikariConfig config = new HikariConfig();
        config.setPoolName("springHikariCP");
        config.setMaximumPoolSize(256);
        config.setMinimumIdle(10);
        config.setConnectionTimeout(10000);
        config.setUsername(env.getProperty("db.jdbc.user"));
        config.setPassword(env.getProperty("db.jdbc.passwd"));
        config.setJdbcUrl(env.getProperty("db.jdbc.url"));
        return config;
    }

    @Bean(destroyMethod = "close")
    HikariDataSource hikariDataSource() {
        return new HikariDataSource(hikariConfig());
    }

    @Bean
    SqlSessionFactoryBean sqlSessionFactory() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(hikariDataSource());
        return bean;
    }
}
