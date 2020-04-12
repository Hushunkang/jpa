package com.atguigu.jpa.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年04月12日 08时56分58秒
 */
@Entity//表示这不是一个普通的实体类而是与数据库表做映射的实体类
@Table(name = "customer")//显式说明我这个实体类映射的表名为customer
public class Customer {

    @Id//表示这个属性对应的是主键字段
    @GeneratedValue(strategy = GenerationType.IDENTITY)//这种策略表示主键由数据库自动生成，支持sql server、mysql、db2等
    private int id;

    @Column//表示这个属性对应的是非主键字段
    private int age;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column
    private String email;

    @Column
    @Temporal(TemporalType.DATE)
    private Date birth;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date gmtCreated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //这是一个工具方法，没必要映射成数据库表的一列，可以加上@Transient注解来实现
    @Transient//其实测试发现，不加这个也没事，只是低版本的jpa+hibernate存在这样的问题，我用的版本较新没问题
    public String getCustomerInfo(){
        return "lastName:" + lastName + ",email:" + email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

}
