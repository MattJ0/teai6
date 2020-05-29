package com.mattjohnson.teai6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Teai6Application {

    public static void main(String[] args) {
        SpringApplication.run(Teai6Application.class, args);
    }

}
