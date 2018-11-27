package com.message.mycache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.message.mycache.mapper")
@SpringBootApplication
@EnableCaching
public class MycacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(MycacheApplication.class, args);
    }
}
