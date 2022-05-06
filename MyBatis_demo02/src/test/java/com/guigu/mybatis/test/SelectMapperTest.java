package com.guigu.mybatis.test;

import com.guigu.mybatis.mapper.SelectMapper;
import com.guigu.mybatis.pojo.User;
import com.guigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class SelectMapperTest {

    /**
     * 1、若查询出的数据只有一条,可以通过实体类对象或集合接收
     *  a>可以通过实体类
     *  b>可以通过list集合
     *  c>可以通过map集合
     *
     * 2、若查询出的数据有多条,可以通过list集合接受,
     *      一定不能通过实体类对象接收,此时会抛出TooManyResultsException异常
     *  a> 可以通过实体类类型list集合
     *  b> 可以通过map类型list集合
     *  c> 可以在mapper接口的方法上添加 @MapKey 注解,
     *      此时就可以将每条数据转换的map集合作为值,以某个字段的值为键,放在同一个map集合中
     *
     *  Mybatis中设置了默认的类别别民
     *  Java.lang.Integer-->int,integer
     *  int-->_int,_integer
     *  Map-->map
     *  String-->string
     *
     */


    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUserToMap());
    }


    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserByIdToMap(6));
    }


    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getCount());
    }


    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        for (User user:mapper.getAllUser()){
            System.out.println(user);
        }
    }


    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserById(6));
    }


}
