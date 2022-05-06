package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MBGTest {

    @Test
    public void testMBGT(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

            //查询所有数据
            System.out.println("\n--------->查询所有数据");
            List<Emp> emps = mapper.selectByExample(null); // 没有查询条件就相当于查询所有数据
            emps.forEach(emp -> System.out.println(emp));

            //根据条件查询 QBC: Query by Criteria
            EmpExample example = new EmpExample();

            //名字叫Bela的
            System.out.println("\n--------->根据条件查询");
            example.createCriteria().andEmpNameEqualTo("Bela");
            List<Emp> emps1 = mapper.selectByExample(example);
            emps1.forEach(emp -> System.out.println(emp));

            //链式添加条件
            System.out.println("\n--------->链式添加条件");
            example.createCriteria().andEmpNameEqualTo("Bela").andAgeEqualTo(33);
            List<Emp> emps2 = mapper.selectByExample(example);
            emps2.forEach(emp -> System.out.println(emp));

            //两个条件用or连接
            System.out.println("\n--------->两个条件用or连接");
            example.createCriteria().andAgeLessThan(30);
            example.or().andDidIsNotNull();
            List<Emp> emps3 = mapper.selectByExample(example);
            emps3.forEach(emp -> System.out.println(emp));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test2(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

            // 原始id=2的数据
            System.out.println("原始id=1的数据"+mapper.selectByPrimaryKey(2));

            // 根据主键修改
            mapper.updateByPrimaryKey(new Emp(2,"改1",55,"男","6789@gamil.com",null));
            System.out.println("\n-----> 根据主键修改----->" + mapper.selectByPrimaryKey(1));

            // 根据主键选择性修改
            mapper.updateByPrimaryKeySelective(new Emp(2,"改2",55,null,"6789@gamil.com",null));
            System.out.println("\n-----> 根据主键选择性修改----->" + mapper.selectByPrimaryKey(1));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
