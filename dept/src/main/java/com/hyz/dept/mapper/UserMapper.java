package com.hyz.dept.mapper;

import com.hyz.dept.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2026-10-14 16:44:13
* @Entity com.hyz.dept.entity.User
*/
@Mapper
public interface UserMapper {
    /** 查询所有用户 */
    List<User> selectAll();
    /** 根据主键查询单个用户 */
    User selectById(@Param("id") Integer id);
    /** 根据用户名查询用户（可用于登录校验） */
    User selectByUsername(@Param("username") String username);
    /** 新增用户 */
    int insert(User user);
    /** 根据主键修改用户 */
    int updateById(User user);
    /** 根据主键删除用户 */
    int deleteById(@Param("id") Integer id);
}
