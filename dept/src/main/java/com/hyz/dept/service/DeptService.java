package com.hyz.dept.service;

import com.hyz.dept.entity.Dept;

import java.util.List;

public interface DeptService {
    //根据id查询部门
    Dept getById(Integer deptno);

    //获取所有部门
    List<Dept> getAll();

    //新增部门信息
    Dept addDept(Dept dept);

    //更新部门信息
    int updateDept(Dept dept);

    //删除部门信息
    int deleteDept(Integer deptno);
}
