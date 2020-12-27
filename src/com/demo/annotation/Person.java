package com.demo.annotation;
@PersonDefaultAnnotaion(username = "张三",gender = "女")
public class Person {
    private String username;
    private String gender;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
