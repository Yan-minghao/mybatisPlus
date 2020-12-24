package com.sirius.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author ymh_sirius
 */
public class MybatisPlusTest {

   private ApplicationContext iocContext= new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test  () throws Exception {
        DataSource ds = iocContext.getBean("dataSource",DataSource.class);
        Connection con = ds.getConnection();
        System.out.println("**************************************************");
        System.out.println(con);
    }



}
