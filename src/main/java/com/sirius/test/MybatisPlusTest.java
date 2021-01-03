package com.sirius.test;

import com.sirius.mp.beans.Employee;
import com.sirius.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author ymh_sirius
 */
public class MybatisPlusTest {
    //①测试获取文档
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    //读取 mapper文件
    private EmployeeMapper employeeMapper = ioc.getBean("employeeMapper", EmployeeMapper.class);


    @Test
    public void test() throws Exception {
        DataSource ds = ioc.getBean("dataSource", DataSource.class);
        Connection con = ds.getConnection();
        System.out.println("**************************************************");
        System.out.println(con);
    }
    //②基于BaseMapper 进行CRUD

    @Test
    public void testIocInsert() throws Exception {
        Employee employee = new Employee();
        employee.setLastName("Do");
        employee.setAge(30);
//        employee.setEmail("ymh25089@163.com");
//        employee.setGender(1);
        System.out.println("employee:----" + employee);
//        employeeMapper.insert(employee);
        employeeMapper.insertAllColumn(employee);
        //获取主键值
        System.out.println("key:-----"+employee.getId(
        ));
    }

    /**
    * 更新操作
    * */
    @Test
    public void updateByIdTest(){
        Employee employee = new Employee();
        employee.setId(11);
        employee.setEmail("hhh@163.com");
       // employeeMapper.updateById(employee);
        employeeMapper.updateAllColumnById(employee);
    }





}
