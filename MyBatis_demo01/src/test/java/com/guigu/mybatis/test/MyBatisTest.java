package com.guigu.mybatis.test;

import com.guigu.mybatis.mapper.UserMapper;
import com.guigu.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    /**
     * sqlSession默认不自动提交事务,若需要自动提交事务
     *可以使用sqlSessionFactory.openSession(true)
     *
     * @throws IOException
     */

    /**
     * 日志的级别：
     * FATAL(致命)>ERROR(错误)>WARN(警告)>INFO(信息)>DEBUG(调试)
     * 从左到右打印的内容越来越详细，即，如果选择DEBUG级别，一定会打印出前面几种级别的信息。
     * @throws IOException
     */

    @Test
    public void testMyBatis() throws IOException {
//        加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//        获取sqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//        获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
//        获取MySession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        获取Mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        测试功能
        int result = mapper.insertUser();
//        提交事务
//        sqlSession.commit();
        System.out.println("result "+result);
    }

    @Test
    public void testUpdate() throws IOException{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();

    }

    @Test
    public void testDelete() throws IOException{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser();
    }

    @Test
    public void testGetUserById() throws IOException{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserById();
        System.out.println(user);
    }

    @Test
    public void testGetAllUser() throws IOException{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(user -> System.out.println(user));

    }


}
