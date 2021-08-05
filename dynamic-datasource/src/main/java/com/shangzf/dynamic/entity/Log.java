package com.shangzf.dynamic.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Log {

    @Id
    private String id;
    private Date registerDate;
    private Date lastModifyDate;
    private String remark;
}
