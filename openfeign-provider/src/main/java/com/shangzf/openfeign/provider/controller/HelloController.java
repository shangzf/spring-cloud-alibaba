package com.shangzf.openfeign.provider.controller;

import com.shangzf.openfeign.provider.entity.dto.HelloDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/get")
    public String get(String name){
        return name;
    }

    @GetMapping("/get/obj")
    public String getObj(HelloDTO dto){
        return dto.getName();
    }

    @PostMapping("/post")
    public String post(@RequestBody HelloDTO dto){
        return dto.getName();
    }

    @PutMapping("/put")
    public String put(@RequestBody HelloDTO dto){
        return dto.getName();
    }

    @DeleteMapping("/del/{id}")
    public String delete(@PathVariable String id){
        return id;
    }
}
