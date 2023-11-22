package com.example.Student2.entity;

public class Student {
    public Student(String name, int age, int salary) {
        super();
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    private String name;
    private int age;
    private int salary;
}
