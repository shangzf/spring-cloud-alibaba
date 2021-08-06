package com.shangzf.openfeign.consumer.client.fall;

import com.shangzf.openfeign.consumer.client.HelloServiceClient;
import com.shangzf.openfeign.consumer.dto.HelloDTO;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceClientFallBack implements FallbackFactory<HelloServiceClient> {
    @Override
    public HelloServiceClient create(Throwable throwable) {
        return new HelloServiceClient() {
            @Override
            public String get(String name) {
                return "default";
            }

            @Override
            public String getObj(HelloDTO dto) {
                return "default";
            }

            @Override
            public String post(HelloDTO dto) {
                return "default";
            }

            @Override
            public String put(HelloDTO dto) {
                return "default";
            }

            @Override
            public String delete(String id) {
                return "default";
            }
        };
    }
}
