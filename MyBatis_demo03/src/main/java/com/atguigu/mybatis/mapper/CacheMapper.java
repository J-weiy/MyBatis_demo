package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {

    /**
     *
     * @param eid
     * @return
     */
    Emp getEmpByEid(@Param("eid") Integer eid);

    /**
     * 添加
     */
    void insertEmp(Emp emp);


}
