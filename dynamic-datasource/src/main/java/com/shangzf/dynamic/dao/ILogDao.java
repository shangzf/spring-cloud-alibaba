package com.shangzf.dynamic.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.shangzf.dynamic.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ILogDao extends JpaRepository<Log, String> {

    @DS("ds1")
    @Query("from Log")
    List<Log> ds1();

    @DS("ds2")
    @Query("from Log")
    List<Log> ds2();

}
