package com.example.observalble.data;

public class StudentBuilder {
    private String name;
    private int age;

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder setAge(int age) {
        this.age = age;
        return this;
    }


}
