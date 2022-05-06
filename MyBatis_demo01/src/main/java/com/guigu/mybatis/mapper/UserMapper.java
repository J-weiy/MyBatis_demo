package com.guigu.mybatis.mapper;

import com.guigu.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * Mybatis面向接口编程的两个一致
     * 1、映射文件的namespace
     * 2、映射文件中SQL语句的id要与mapper接口中方法名一致
     */

    /**
     * 添加用户信息
     */
    int insertUser();

    /**
     * 修改用户信息
     */
    void updateUser();

    /**
     * 删除用户信息
     */
    void deleteUser();

    /**
     * 根据id查询用户信息
     */
    User getUserById();

    /**
     * 查询所有用户信息
     */
    List<User> getAllUser();

}
