package com.atguigu.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 用JAVA 实现一种排序，JAVA 类实现序列化的方法？ 在COLLECTION 框架中，实现比较要实现什么样的接口？
 */
public class OrderTest2 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>() {
            {
                add(new Student(1, "a", 2));
                add(new Student(3, "a", 3));
                add(new Student(7, "a", 5));
                add(new Student(5, "a", 2));
                add(new Student(3, "a", 2));
                add(new Student(7, "c", 2));
                add(new Student(1, "b", 5));
                add(new Student(7, "a", 2));
                add(new Student(7, "c", 10));

            }
        };

        Collections.sort(students);
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

class Student implements Comparable<Student> {

    private int number;

    private String name;

    private float score;

    public Student(int number, String name, float score) {
        this.number = number;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student s) {
        if (this.number != s.number) {
            return this.number > s.number ? 1 : -1;
        } else {
            if (this.name.equals(s.name)) {
                return this.score < s.score ? 1 : -1;
            }
            return this.name.compareTo(s.name) > 0 ? 1 : -1;
        }
    }
}
