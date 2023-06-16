package com.zhsnail.esdata.etl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan("com.zhsnail.esdata")
public class EsDataEtlApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsDataEtlApplication.class, args);
    }

}
