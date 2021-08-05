package com.shangzf.dynamic;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DynamicApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(DynamicApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }
}
