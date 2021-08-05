package com.shangzf.dynamic.controller;

import com.shangzf.dynamic.dao.ILogDao;
import com.shangzf.dynamic.mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo1")
public class Demo1 {

    @Autowired
    private ILogDao dao;

    @Autowired
    private LogMapper mapper;

    @GetMapping("print")
    public String print() {
        return "demo1";
    }

    @GetMapping("log1/{type}")
    public String log1(@PathVariable Integer type) {
        if (type > 0) {
            return dao.ds2().toString();
        } else {
            return dao.ds1().toString();
        }
    }

    @GetMapping("log/{type}")
    public String log(@PathVariable Integer type) {
        if (type == 1) {
            return mapper.ds1().toString();
        } else if (type == 2) {
            return mapper.ds2().toString();
        } else {
            return mapper.ds3().toString();
        }
    }
}
