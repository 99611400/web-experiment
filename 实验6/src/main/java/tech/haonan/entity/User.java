package tech.haonan.entity;

import org.springframework.lang.NonNull;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.awt.*;
import java.io.Serializable;

/**
 * @Author: yhn
 * @Date: 10/8/2020 7:48 PM
 * @Description:
 **/

/*
CREATE TABLE IF NOT EXISTS `userTable`(
        `id` INT UNSIGNED AUTO_INCREMENT primary key COMMENT '用户编号',
        `username` VARCHAR(20) NOT NULL UNIQUE COMMENT '用户名',
        `password` CHAR(32) NOT NULL COMMENT '密码',
        `email` VARCHAR(50) NOT NULL UNIQUE COMMENT '邮箱',
        `age` TINYINT UNSIGNED NOT NULL DEFAULT 18 COMMENT '年龄',
        `sex` ENUM('man','woman','secret') NOT NULL DEFAULT 'secret' COMMENT '性别',
        `tel` CHAR(11) NOT NULL UNIQUE COMMENT '电话',
        `addr` VARCHAR(50) NOT NULL DEFAULT 'beijing' COMMENT '地址',
        `idNumber` CHAR(18) NOT NULL UNIQUE COMMENT '身份证号',
        `married` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '0代表未结婚，1代表已结婚',
        `salary` FLOAT(8,2) NOT NULL DEFAULT 0 COMMENT '薪水'
)CHARSET=UTF8;
* */

public class User implements Serializable {// 实现序列化接口
    private Long id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    private String email;
    private Integer age;
    private String sex;
    private String tel;
    private String addr;
    private String idNumber;
    private boolean married;
    private Float salary;

    public User(Long id, String username, String password, String email, Integer age, String sex, String tel, String addr, String idNumber, boolean married, Float salary) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.sex = sex;
        this.tel = tel;
        this.addr = addr;
        this.idNumber = idNumber;
        this.married = married;
        this.salary = salary;
    }

    public User(String username, String password, String email, Integer age, String sex, String tel, String addr, String idNumber, boolean married, Float salary) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.sex = sex;
        this.tel = tel;
        this.addr = addr;
        this.idNumber = idNumber;
        this.married = married;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", tel='" + tel + '\'' +
                ", addr='" + addr + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", married=" + married +
                ", salary=" + salary +
                '}';
    }
}
