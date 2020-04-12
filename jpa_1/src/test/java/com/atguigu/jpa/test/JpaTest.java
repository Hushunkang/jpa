package com.atguigu.jpa.test;

import com.atguigu.jpa.entity.Customer;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年04月12日 09时57分24秒
 */
public class JpaTest {

    @Test
    public void test01(){
        //1、创建EntitymanagerFactory
        String persistenceUnitName = "jpa_1";
        Map<String, Object> properites = new HashMap<>();
        properites.put("hibernate.show_sql", true);
        EntityManagerFactory entityManagerFactory =
                //Persistence.createEntityManagerFactory(persistenceUnitName);
                Persistence.createEntityManagerFactory(persistenceUnitName, properites);

        //2、创建EntityManager，类似于Hibernate的SessionFactory
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //3、开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        //4、进行持久化操作
        Customer customer = new Customer();
        customer.setAge(12);
        customer.setEmail("tom@atguigu.com");
        customer.setLastName("Tom");
//        customer.setBirth(new Date());
//        customer.setCreatedTime(new Date());
        entityManager.persist(customer);

        //5、提交事务
        transaction.commit();

        //6、关闭EntityManager
        entityManager.close();

        //7、关闭EntityManagerFactory
        entityManagerFactory.close();
    }

}
