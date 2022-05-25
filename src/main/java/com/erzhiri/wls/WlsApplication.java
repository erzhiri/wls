package com.erzhiri.wls;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.erzhiri.wls.mapper")
public class WlsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WlsApplication.class, args);
    }

}
