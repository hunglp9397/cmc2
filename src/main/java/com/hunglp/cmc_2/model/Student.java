package com.hunglp.cmc_2.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("student")
@Data
public class Student {

    @Value("${student.rollNo}")
    private int rollNo;

    @Value("${student.name}")
    private String name;

    @Value("${student.age}")
    private int age;

    public Student() {
    }

    public Student(int rollNo, String name, int age) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
