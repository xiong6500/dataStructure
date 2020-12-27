package com.demo.annotation;

import java.util.Date;

public class Employee {

    private String name;//姓名
    @DateAnnotation(value = "2018/09/21",pattern = "yyyy/MM/dd")
    private Date inTime;//入职时间

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", inTime=" + inTime +
                '}';
    }
}
