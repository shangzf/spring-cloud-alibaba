package com.shangzf.openfeign.consumer.client;

import com.shangzf.openfeign.consumer.client.fall.HelloServiceClientFallBack;
import com.shangzf.openfeign.consumer.dto.HelloDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "openfeign-provider", fallbackFactory = HelloServiceClientFallBack.class)
public interface HelloServiceClient {

    @GetMapping("/get")
    String get(@RequestParam("name") String name);

    @GetMapping("/get/obj")
    String getObj(@SpringQueryMap HelloDTO dto);

    @PostMapping("/post")
    String post(@RequestBody HelloDTO dto);

    @PutMapping("/put")
    String put(@RequestBody HelloDTO dto);

    @DeleteMapping("/del/{id}")
    String delete(@PathVariable("id") String id);
}
