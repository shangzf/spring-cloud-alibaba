package com.shangzf.openfeign.consumer.controller;

import com.shangzf.openfeign.consumer.client.HelloServiceClient;
import com.shangzf.openfeign.consumer.dto.HelloDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private HelloServiceClient client;

    @GetMapping("/get")
    public String get(String name){
        return client.get(name);
    }

    @GetMapping("/get/obj")
    public String getObj(HelloDTO dto){
        return client.getObj(dto);
    }

    @PostMapping("/post")
    public String post(@RequestBody HelloDTO dto){
        return client.post(dto);
    }

    @PutMapping("/put")
    public String put(@RequestBody HelloDTO dto){
        return client.put(dto);
    }

    @DeleteMapping("/del/{id}")
    public String delete(@PathVariable String id){
        return client.delete(id);
    }
}
