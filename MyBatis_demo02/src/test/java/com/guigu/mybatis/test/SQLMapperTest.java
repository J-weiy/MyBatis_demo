package com.guigu.mybatis.test;

import com.guigu.mybatis.mapper.SQLMapper;
import com.guigu.mybatis.pojo.User;
import com.guigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SQLMapperTest {

    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> list = mapper.getUserByLike("admin");
        System.out.println(list);
    }

    @Test
    public void testDeleteMore(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        int result = mapper.deleteMore("5,6,7");
        System.out.println(result);
    }

    @Test
    public void testGetUserByTableName(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> list = mapper.getUserByTableName("t_user");
        System.out.println(list);
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        User user = new User(null,"王五","123456",23,"男","123@qq.com");
        mapper.insertUser(user);
        System.out.println(user);

    }

}
