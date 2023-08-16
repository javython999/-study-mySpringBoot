package com.example.myspringboot;

import com.example.config.MySpringBootApp;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;

@MySpringBootApp
public class MySpringBootApplication {

    private final JdbcTemplate jdbcTemplate;

    public MySpringBootApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    void init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
    }

}
