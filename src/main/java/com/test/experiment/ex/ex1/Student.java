package com.test.experiment.ex.ex1;

/**
 * @author tangrd
 * @date 2020/6/1 17:20
 * @destination
 */

public class Student {
    private String name;

    private String password;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }

    public Student(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public Student() {
    }
}
