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

    /*
    * 查询
    * */
    @Test
    public void selectTest(){
        Employee employee = new Employee();
        //1.selectbyId 查询
//        Employee employee1 = employeeMapper.selectById(1);
//        System.out.println("employee_____________________"+employee);

       //2.selectOne 查询 只能查询出一条数据
//        employee.setId(1);
       // employee.setLastName("Do");
//        Employee employee2 = employeeMapper.selectOne(employee);
//        System.out.println("------------selectOne start---------");
//        System.out.println(employee2);
//        System.out.println("------------selectOne end---------");

        //3.selectBatchIds 查询 只能查询出一条数据
//        List<String> list = new ArrayList<String>();
//        for(int i=0;i<100;i++){
//            list.add(Integer.toString(i));
//        }
//        List<Employee> employees = employeeMapper.selectBatchIds(list);
//        System.out.println("------------selectBatchIds start---------");
//        System.out.println(employees);
//        System.out.println("------------selectBatchIds end---------");

        //4.selectByMpa 查询 只能查询出一条数据
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("gender","1");
//        List<Employee> employeeList= employeeMapper.selectByMap(map);
//        System.out.println("------------selectByMpa start---------");
//        System.out.println(employeeList);
//        System.out.println("------------selectByMpa end---------");

    }



}
