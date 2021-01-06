package com.sirius.test;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.sirius.mp.beans.Employee;
import com.sirius.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

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
        System.out.println("key:-----" + employee.getId(
        ));
    }

    @Test
    public void testSelect() {
        Employee employee = new Employee();
        System.out.println("----------selectPage   start--------");
        List<Employee> employees = employeeMapper.selectPage(new Page(1, 1), null);
        System.out.println(employees);
        System.out.println("----------selectPage   end--------");

    }

    @Test
    public void testDelete() {
        //1.deleteById
//        System.out.println("----------deleteById   start--------");
//        Integer res = employeeMapper.deleteById(12);
//        System.out.println(res);
//        System.out.println("----------deleteById   end--------");


        //2.deleteByMap
//        System.out.println("----------deleteByMap   start--------");
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("id",10);
//
//        Integer integer = employeeMapper.deleteByMap(map);
//        System.out.println(integer);
//        System.out.println("----------deleteByMap   end--------");


        System.out.println("----------deleteBatchIds   start--------");
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        Integer integer = employeeMapper.deleteBatchIds(list);
        System.out.println(integer);
        System.out.println("----------deleteBatchIds   end--------");
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

    /**
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

        //5.selectPage
        System.out.println("----------selectPage   start--------");
        List<Employee> employees = employeeMapper.selectPage(new Page(1, 1), null);
        System.out.println(employees);
        System.out.println("----------selectPage   end--------");

    }

    /**
    * 条件选择器
    * */
    @Test
    public void testEntityWrapper(){
        //1.entityWrapper selectPage
        List<Employee> last_name = employeeMapper.selectPage(new Page(1, 1), new EntityWrapper<Employee>()
                .eq("last_name", "1"));
//        System.out.println(last_name);
        System.out.println("-----------start");
        //2.entityWrapper selectList
//         List<Employee> last_name1 = employeeMapper.selectList(new EntityWrapper<Employee>().like("last_name", "1"));
//        System.out.println(last_name1);
        System.out.println("------  update  -----");
        //3.update 更新
        //Employee employee = new Employee();
        //employee.setAge(23);
        //employeeMapper.update(employee,new EntityWrapper<Employee>().eq("age","444"));
        //4.delete
//        Integer result = employeeMapper.delete(new EntityWrapper<Employee>().eq("last_name", "1"));
//        System.out.println(result);

        //5.condition
        List list = employeeMapper.selectPage(new Page<Employee>(1, 1), Condition.create().eq("last_name", "11"));
        System.out.println(list);
    }

}
