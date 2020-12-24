package com.sirius.mp.beans;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@TableName(value="tbl_employee")
public class Employee {

    /**
     * 主键
     */
    @TableId(value = "id",type= IdType.AUTO)
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
}
