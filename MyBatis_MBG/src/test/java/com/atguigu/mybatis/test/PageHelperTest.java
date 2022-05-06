package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PageHelperTest {

    /**
     * limit    index，pagesize
     * index    当前页的起始索引
     * pageSize 每页显示的条数
     * pageNum  当前页的页码
     * 当前页的起始索引 = 每页条数 * 页码 - 1
     * index = pageNum * pageSize - 1
     *
     * 通过索引获得数据
     *
     * 使用MyBatis的分页插件，实现分页功能：
     * 1。需要在查询功能之前开启分页
     * PageHelper.startPage(2, 4);
     *
     * 2。在查询功能之后获取分页相关信息
     *   PageInfo<Emp> pages = new PageInfo<>(emps, 5); 5表示导航分页的数量
     *
     */

    @Test
    public void testPageHelper() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

            System.out.println("\n查询功能前开启分页");
            PageHelper.startPage(2, 4);
            List<Emp> emps = mapper.selectByExample(null);
            emps.forEach(emp -> System.out.println(emp));

            System.out.println("\n");
            PageInfo<Emp> pages = new PageInfo<>(emps, 5);
            System.out.println("PageInfo----->" + pages);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
