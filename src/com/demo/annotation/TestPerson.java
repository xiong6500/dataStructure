package com.demo.annotation;

import java.lang.reflect.Field;

public class TestPerson {
    public static Person getPersonInstance() throws Exception {
        //获得人员类的类信息对象
        Class classz = Person.class;
        //获得注解
        PersonDefaultAnnotaion pda = (PersonDefaultAnnotaion) classz.getAnnotation(PersonDefaultAnnotaion.class);
        //获得注解属性
        /*String username = pda.username();
        int age = pda.age();
        String gender = pda.gender();
        //创建人员对象
        Person person = (Person) classz.newInstance();
        //设置属性
        Field field = classz.getDeclaredField("username");
        field.setAccessible(true);
        field.set(person,username);
        field = classz.getDeclaredField("age");
        field.setAccessible(true);
        field.set(person,age);
        field = classz.getDeclaredField("gender");
        field.setAccessible(true);
        field.set(person,gender);*/
        Person person = (Person) classz.newInstance();
        Field[] fields = classz.getDeclaredFields();
        for (Field field : fields) {
            // 取消访问权限private
            field.setAccessible(true);
            //给属性设置
            field.set(person,pda.getClass().getMethod(field.getName()).invoke(pda));
        }
        return person;
    }

    public static void main(String[] args) throws Exception {
        Person personInstance = getPersonInstance();
        System.out.println(personInstance);
    }
}
