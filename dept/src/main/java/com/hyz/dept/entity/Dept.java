package com.hyz.dept.entity;

import lombok.Data;

@Data
public class Dept {
    //数据表没有设置主键自增
    private Integer deptno;
    private String dname;
    private String loc;
}
