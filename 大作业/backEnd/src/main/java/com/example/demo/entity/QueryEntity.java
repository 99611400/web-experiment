package com.example.demo.entity;

import java.util.Date;

/**
 * @Author: yhn
 * @Date: 11/19/2020 9:07 PM
 * @Description:
 **/
public class QueryEntity {
    private String label;
    private String clientType;
    private RangeTime searchCreateTime;
    private String CreatePerson;

    @Override
    public String toString() {
        return "QueryEntity{" +
                "label='" + label + '\'' +
                ", clientType='" + clientType + '\'' +
                ", rangeTime=" + searchCreateTime +
                ", CreatePerson='" + CreatePerson + '\'' +
                '}';
    }

    public QueryEntity(String label, String clientType, RangeTime searchCreateTime, String createPerson) {
        this.label = label;
        this.clientType = clientType;
        this.searchCreateTime = searchCreateTime;
        CreatePerson = createPerson;
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

    public RangeTime getSearchCreateTime() {
        return searchCreateTime;
    }

    public void setSearchCreateTime(RangeTime searchCreateTime) {
        this.searchCreateTime = searchCreateTime;
    }

    public String getCreatePerson() {
        return CreatePerson;
    }

    public void setCreatePerson(String createPerson) {
        CreatePerson = createPerson;
    }
}


