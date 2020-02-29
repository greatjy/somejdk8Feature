package com.imooc.byennsix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.imooc.byennsix")
public class ByennsixApplication {

    public static void main(String[] args) {
        SpringApplication.run(ByennsixApplication.class, args);
    }

}
