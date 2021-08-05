package com.shangzf.sentinel;


import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.shangzf")
@EnableDiscoveryClient
@SpringBootApplication
public class SentinelApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SentinelApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }
}
