package com.pn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.pn.mapper")
@SpringBootApplication
public class TkSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TkSpringBootApplication.class, args);
    }

}
