package com.shangzf.seata.controller;

import com.shangzf.seata.entity.Log;
import com.shangzf.seata.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private TestService service;

    @GetMapping("/save")
    public List<Log> save(){
        return service.save();
    }
}
