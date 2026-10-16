package com.hyz.dept.service.impl;

import com.hyz.dept.entity.Dept;
import com.hyz.dept.mapper.DeptMapper;
import com.hyz.dept.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public Dept getById(Integer deptno) {
        return deptMapper.selectByDeptno(deptno);
    }

    @Override
    public List<Dept> getAll() {
        return deptMapper.selectAll();
    }

    @Override
    public Dept addDept(Dept dept) {
        Integer maxNo = deptMapper.selectMaxDeptno();
        Integer newDeptno = maxNo == null ? 1 : maxNo + 1;
        dept.setDeptno(newDeptno); // 修改传入对象的主键
        deptMapper.insert(dept);
        return dept; // 返回填充好主键的完整dept对象
    }

    @Override
    public int updateDept(Dept dept) {
        return deptMapper.updateByDeptno(dept);
    }

    @Override
    public int deleteDept(Integer deptno) {
        return deptMapper.deleteByDeptno(deptno);
    }
}
