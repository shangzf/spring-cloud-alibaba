package com.shangzf.openfeign.provider;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.shangzf")
@EnableDiscoveryClient
@SpringBootApplication
public class OpenfeignProviderApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(OpenfeignProviderApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
