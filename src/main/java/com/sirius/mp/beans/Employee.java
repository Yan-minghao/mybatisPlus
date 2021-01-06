package com.sirius.mp.beans;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
//@TableName(value="tbl_employee")
public class Employee extends Model<Employee> {
//    ActiveRecord(活动记录)
    /**
     * 主键
     */
    //@TableId(value = "id",type= IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    @TableField("last_name")
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
     * 主键
    * */
    @Override
    protected Serializable pkVal() {
        return id;
    }
    /**
     * 金额
     */
//    @TableField(exist=false)
//    private Double salary;
}
