package com.atguigu.jpa.entity;

import javax.persistence.*;

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

    @Column
    private String lastName;

    @Column
    private String email;

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

}
