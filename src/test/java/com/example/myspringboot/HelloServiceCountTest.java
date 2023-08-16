package com.example.myspringboot;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@MySpringbootTest
public class HelloServiceCountTest {
    @Autowired
    HelloService helloService;

    @Autowired
    HelloRepository helloRepository;

    @Test
    void sayHelloIncreaseCountTest() {

        IntStream.rangeClosed(1, 10).forEach(count -> {
            helloService.sayHello("kim");
            assertThat(helloRepository.countOf("kim")).isEqualTo(count);
        });
    }

}
