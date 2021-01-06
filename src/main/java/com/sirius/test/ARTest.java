package com.sirius.test;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.plugins.Page;
import com.sirius.mp.beans.Employee;
import com.sirius.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ymh sirius
 * ActiveRecord(活动记录)
 */
public class ARTest {
    //①测试获取文档
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    //读取 mapper文件
    private EmployeeMapper employeeMapper = ioc.getBean("employeeMapper", EmployeeMapper.class);
    Employee employee = new Employee();
    //insert
    @Test
    public void arInsert(){
//        employee.setAge(27);
//        employee.setLastName("sirius");
//        employee.setEmail("ymh@163.com");
//        employee.setGender(1);
//        boolean insert = employee.insert();
//        System.out.println(insert);
    }
    //update
    @Test
    public void testUpdate(){
        Employee employee = new Employee();
        employee.setLastName("sirius");
        employee.setEmail("ymh@163.com");
        employee.setId(3);
        employee.updateById();
    }
    //select
    @Test
    public void testSelect(){
        //1.selectbyId
//        Employee employee = new Employee();
//        employee.setId(11);
//        Employee employee1 = employee.selectById();
//        System.out.println(employee1);
        //2.public T selectById(Serializable id)
//        Employee employee2 = employee.selectById(13);
//        System.out.println("-------------------");
//        System.out.println(employee2);
        //3.selectAll
//        System.out.println("-------selectAll-");
//        Employee employee = new Employee();
//        System.out.println(employee.selectAll());
        //4.selectList
//        List<Employee> age = employee.selectList(new EntityWrapper().eq("age", "27"));
//        System.out.println(age);
        //5.selectCount
//        int age = employee.selectCount(Condition.create().eq("age", "23"));
//        System.out.println(age);

        //6.selectPage
    }
    //1.delete
    @Test
    public void testDelete(){
        //1.deleteById
//        employee.setId(3);
//        boolean b = employee.deleteById();
//        System.out.println(b);
        //2.deleteById(id);
//        boolean b = employee.deleteById(4);
//        System.out.println(b);
         //3.public boolean delete(Wrapper wrapper)
//        employee.delete(Condition.create().eq("last_name","test"));
    }

    @Test
    public void testHello(){
        Page age = employee.selectPage(new Page<Employee>(), Condition.create().eq("age", "23"));
        System.out.println(age.getRecords());
    }



}
