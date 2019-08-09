package com.latidude99.links;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

//@EnableConfigurationProperties(AppProperties.class)
//@EnableAutoConfiguration
@SpringBootApplication
public class LinksApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinksApplication.class, args);
    }

}
