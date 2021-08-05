package com.shangzf.seata.dao;

import com.shangzf.seata.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILogDao extends JpaRepository<Log, String> {
}
