package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {


    /**
     * 多条件查询
     */
    List<Emp> getEmpByCondition(Emp emp);

    /**
     * 测试choose、when、chosewise
     */
    List<Emp> getEmpByChoose(Emp emp);

    /**
     * 通过数组实现批量删除
     */
    int deleteMoreByArray(@Param("eids") Integer[] eids);


    
}
