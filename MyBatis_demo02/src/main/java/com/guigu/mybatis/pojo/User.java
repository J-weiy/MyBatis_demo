package com.guigu.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String sex;
    private String email;

}
