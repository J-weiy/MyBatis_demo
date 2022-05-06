package com.guigu.mybatis.test;

import com.guigu.mybatis.mapper.ParameterMapper;
import com.guigu.mybatis.pojo.User;
import com.guigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParamMapperTest {

    /**
     * Mybatis获取参数值的两种方式：${} 和 #{}
     * ${} 本质字符串拼接
     * #{} 本质占位符赋值
     *
     * 除特殊情况外 优先使用#{}
     *
     * MyBatis获取参数值的各种情况
     *
     * 1、mapper接口方法的参数为单个的字面量类型
     *   可以通过${}和#{}以任意的名称获取参数值,但是需要注意${}单引号问题
     *
     * 2、mapper接口方法为多个时
     *   此时MyBatis会将这些参数放在一个map接口中,以两种方式存储
     *   a> 以arg0,arg1...为键,以参数为值
     *   b> 以param1,param2...为键,以参数为值
     *   因此只需要通过#{}和${}以键的方式访问即可,但是需要注意${}的单引号问题。
     *
     * 3、若mapper接口方法的参数有多个时,可以手动将这些参数放在一个map中存储
     *   只需要通过#{}和${}以键的方式访问值即可,但是要注意${}的单引号问题
     *
     * 4、mapper接口方法的参数是实体类类型的参数
     *   只需要通过#{}和${}以属性的方式访问属性值即可,但是要注意${}的单引号问题
     *
     * 5、使用@Param注解命名参数
     *   此时MyBatis会将这些参数放在一个map接口中,以两种方式存储
     *   a> 以arg0,arg1...为键,以参数为值
     *   b> 以param1,param2...为键,以参数为值
     *   因此只需要通过#{}和${}以键的方式访问即可,但是需要注意${}的单引号问题。
     *
     */


    @Test
    public void testCheckLoginByParam(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLoginByParam("admin","123456");
        System.out.println(user);
    }


    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        int result = mapper.insertUser(new User(null, "李四", "123", 23, "男", "123131@"));
        System.out.println(result);
    }


    @Test
    public void testCheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("username","admin");
        map.put("password","123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }


    @Test
    public void testCheckLogin(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("admin","123456");
        System.out.println(user);
    }


    @Test
    public void testGetUserByUsername(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.getUserByUsername("admin");
        System.out.println(user);
    }


    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(user -> System.out.println(user));
    }


    @Test
    public void testJDBC() throws Exception{
        String username = "admin";
        Class.forName("");
        Connection connection = DriverManager.getConnection("", "", "");
//      connection.prepareStatement("select * from t_user where username = '"+username+"'");
        PreparedStatement ps = connection.prepareStatement("select * from t_user where username = ?");
        ps.setString(1,username);
    }


}
