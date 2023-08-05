package com.example.config;

import com.example.config.autoconfig.DispatcherServletConfiguration;
import com.example.config.autoconfig.TomcatWebServerConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Configuration
@ComponentScan
@Import({DispatcherServletConfiguration.class, TomcatWebServerConfiguration.class})
public @interface EnableMyAutoConfiguration {
}
