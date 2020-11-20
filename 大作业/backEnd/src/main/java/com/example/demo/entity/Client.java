package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Data;

import java.util.Date;

/**
 * @Author: yhn
 * @Date: 11/18/2020 10:39 AM
 * @Description:
 **/
/*
create table client(
    id int primary key auto_increment comment '主键 id',
    clientName varchar(30) comment '客户名',
    label varchar(30) comment '标签',
    clientType varchar(30)  comment '客户类型',
    province varchar(30) comment '省份',
    city varchar(30) comment '城市',
    nextContactTime date comment '下一次联系时间',
    createTime date comment '创建时间',
    createPerson varchar(30) comment '创建人',
    clientAllocationTime varchar(30) comment '客户分配时间',
    lastContactTime date comment '最后联系时间',
    lastContactPerson varchar(30) comment '最后联系人'
)charset utf8;
 */

public class Client {
    private Integer id;
    private String clientName;
    private String label;
    private String clientType;
    private String province;
    private String city;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date nextContactTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    private String  createPerson;
    private String clientAllocationTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lastContactTime;
    private String lastContactPerson;

    public Client(String clientName, String label, String clientType, String province, String city, Date nextContactTime, Date createTime, String createPerson, String clientAllocationTime, Date lastContactTime, String lastContactPerson) {
        this.clientName = clientName;
        this.label = label;
        this.clientType = clientType;
        this.province = province;
        this.city = city;
        this.nextContactTime = nextContactTime;
        this.createTime = createTime;
        this.createPerson = createPerson;
        this.clientAllocationTime = clientAllocationTime;
        this.lastContactTime = lastContactTime;
        this.lastContactPerson = lastContactPerson;
    }

    public Client(Integer id, String clientName, String label, String clientType, String province, String city, Date nextContactTime, Date createTime, String createPerson, String clientAllocationTime, Date lastContactTime, String lastContactPerson) {
        this.id = id;
        this.clientName = clientName;
        this.label = label;
        this.clientType = clientType;
        this.province = province;
        this.city = city;
        this.nextContactTime = nextContactTime;
        this.createTime = createTime;
        this.createPerson = createPerson;
        this.clientAllocationTime = clientAllocationTime;
        this.lastContactTime = lastContactTime;
        this.lastContactPerson = lastContactPerson;
    }

    public Client() {
    }

    public Client(Integer id, String clientName) {
        this.id = id;
        this.clientName = clientName;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", label='" + label + '\'' +
                ", clientType='" + clientType + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", nextContactTime=" + nextContactTime +
                ", createTime=" + createTime +
                ", createPerson='" + createPerson + '\'' +
                ", clientAllocationTime='" + clientAllocationTime + '\'' +
                ", lastContactTime=" + lastContactTime +
                ", lastContactPerson='" + lastContactPerson + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getNextContactTime() {
        return nextContactTime;
    }

    public void setNextContactTime(Date nextContactTime) {
        this.nextContactTime = nextContactTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public String getClientAllocationTime() {
        return clientAllocationTime;
    }

    public void setClientAllocationTime(String clientAllocationTime) {
        this.clientAllocationTime = clientAllocationTime;
    }

    public Date getLastContactTime() {
        return lastContactTime;
    }

    public void setLastContactTime(Date lastContactTime) {
        this.lastContactTime = lastContactTime;
    }

    public String getLastContactPerson() {
        return lastContactPerson;
    }

    public void setLastContactPerson(String lastContactPerson) {
        this.lastContactPerson = lastContactPerson;
    }
}
