package com.atguigu.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {

    private Integer eid;

    private String empName;

    private Integer age;

    private String sex;

    private String email;

    private Dept dept;


}
