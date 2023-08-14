package com.example.myspringboot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@MySpringbootTest
public class HelloRepositoryTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    HelloRepository helloRepository;

    @BeforeEach
    void init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }

    @Test
    void findHelloTest() {
        assertThat(helloRepository.findHello("kim")).isNull();
    }

    @Test
    void increaseCount() {
        assertThat(helloRepository.countOf("kim")).isEqualTo(0);

        helloRepository.increaseCount("kim");
        assertThat(helloRepository.countOf("kim")).isEqualTo(1);

        helloRepository.increaseCount("kim");
        assertThat(helloRepository.countOf("kim")).isEqualTo(2);
    }
}
