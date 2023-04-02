package com.example.databasedesign;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.databasedesign.mapper")
public class DatabaseDesignApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseDesignApplication.class, args);
    }

}
