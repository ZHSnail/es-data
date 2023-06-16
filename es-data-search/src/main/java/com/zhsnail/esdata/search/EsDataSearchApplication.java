package com.zhsnail.esdata.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class EsDataSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsDataSearchApplication.class, args);
    }

}
