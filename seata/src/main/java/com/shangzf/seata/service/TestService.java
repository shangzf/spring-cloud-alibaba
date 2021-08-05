package com.shangzf.seata.service;

import com.shangzf.seata.dao.ILogDao;
import com.shangzf.seata.entity.Log;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@GlobalTransactional
public class TestService {

    @Autowired
    private ILogDao dao;

    public List<Log> save() {
        Log log = new Log();
        log.setId(UUID.randomUUID().toString().substring(0,10));
        dao.save(log);
        return dao.findAll();
    }
}
