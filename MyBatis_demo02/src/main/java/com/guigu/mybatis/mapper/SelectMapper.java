package com.guigu.mybatis.mapper;

import com.guigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.Map;
import java.util.List;

public interface SelectMapper {

    /**
     * 根据id查询用户信息
     */
    List<User> getUserById(@Param("id") Integer id);

    /**
     * 查询所有用户信息
     */
    List<User> getAllUser();

    /**
     * 查询用户的总记录数
     */
    Integer getCount();

    /**
     * 根据id查询用户信息为一个map集合
     */
    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);

    /**
     * 查询所有用户信息为map集合
     */
//    List<Map<String,Object>> getAllUserToMap();
    @MapKey("id")
    Map<String,Object> getAllUserToMap();


}
