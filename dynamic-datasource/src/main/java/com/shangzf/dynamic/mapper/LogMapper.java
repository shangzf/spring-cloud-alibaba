package com.shangzf.dynamic.mapper;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.shangzf.dynamic.entity.Log;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogMapper {

    @DS("ds2")
    List<Log> ds2();

    @DS("ds1")
    List<Log> ds1();

    @DS("ds3")
    List<Log> ds3();
}
