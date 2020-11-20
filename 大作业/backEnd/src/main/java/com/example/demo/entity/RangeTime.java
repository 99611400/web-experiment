package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: yhn
 * @Date: 11/19/2020 9:37 PM
 * @Description:
 **/
public class RangeTime{
    @DateTimeFormat(pattern = "yyyyMMdd")
    private Date beginTime;
    @DateTimeFormat(pattern = "yyyyMMdd")
    private Date endTime;

    public RangeTime(Date beginTime, Date endTime) {
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "RangeTime{" +
                "beginTime=" + beginTime +
                ", endTime=" + endTime +
                '}';
    }
}