package com.jmeter.spring.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.jmeter.spring"})
public class TestConfig {

}
