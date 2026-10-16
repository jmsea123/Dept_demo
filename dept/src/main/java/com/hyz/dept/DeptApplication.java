package com.hyz.dept;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hyz.dept.mapper")
public class DeptApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeptApplication.class, args);
    }

}
