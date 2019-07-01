package com.alpha.heroku.test.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

/**
 * @author alpha @Date 2017/10/31
 */
@Configuration
public class BeanConfiguration {

    @Value("${DATABASE_URL}")
    private String connString;

    private String url;
    private String username;
    private String password;

    @Bean
    public DruidDataSource dataSource() throws SQLException {
        initConnInfo();
        String driver = "org.postgresql.Driver";
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setInitialSize(1);
        druidDataSource.setMinIdle(1);
        druidDataSource.setMaxActive(20);
        druidDataSource.setMaxWait(60000);
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        druidDataSource.setValidationQuery("select 'x'");
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnReturn(false);
        druidDataSource.setPoolPreparedStatements(true);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setFilters("stat,wall,log4j");
        druidDataSource.init();

        return druidDataSource;
    }

    /**
     * postgres://aochdhrpaqltzi:9e77d96469ef02e2b39f2c69945257fbe93811edae910f036b2869ed7536e70a@ec2-174-129-227-80.compute-1.amazonaws.com:5432/d2974qivb373ov
     */
    private void initConnInfo() {
        // jdbc:postgresql://ec2-174-129-227-80.compute-1.amazonaws.com:5432/d2974qivb373ov?sslmode=require

        String[] arr = connString.split("@");
        if (arr.length != 2) {
            throw new RuntimeException("非heroku环境变量");
        }
        this.url = "jdbc:postgresql://" + arr[1] + "?sslmode=require";

        arr = arr[0].split(":");
        if (arr.length != 3) {
            throw new RuntimeException("非heroku环境变量");
        }
        this.username = arr[1].replace("//", "");
        this.password = arr[2];
    }
}