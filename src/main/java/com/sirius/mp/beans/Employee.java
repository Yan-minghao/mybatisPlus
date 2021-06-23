package com.sirius.mp.beans;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Employee {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 姓名
     */
    private String lastName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
    * 身价
    * */
    private String money;
}
