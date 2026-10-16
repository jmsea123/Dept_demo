package com.hyz.dept.mapper;

import com.hyz.dept.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【dept】的数据库操作Mapper
* @createDate 2026-10-14 16:44:13
* @Entity com.hyz.dept.entity.Dept
*/
/**
 * 部门表 Mapper 接口
 */
@Mapper
public interface DeptMapper {
    /** 查询所有部门 */
    List<Dept> selectAll();
    /** 根据部门编号查询单个部门 */
    Dept selectByDeptno(@Param("deptno") Integer deptno);
    /** 新增部门 */
    int insert(Dept dept);
    /** 根据部门编号修改部门 */
    int updateByDeptno(Dept dept);
    /** 根据部门编号删除部门 */
    int deleteByDeptno(@Param("deptno") Integer deptno);
    /** 获取最大部门编号 */
    Integer selectMaxDeptno();
}
