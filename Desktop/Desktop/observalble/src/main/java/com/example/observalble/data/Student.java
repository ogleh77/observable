package com.example.observalble.data;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student {
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleIntegerProperty age = new SimpleIntegerProperty();


    public Student(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
        System.out.println("name have " + this.name.getValue());
    }

    public int getAge() {
        return age.get();
    }

    public SimpleIntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
        System.out.println("age have " + this.age.getValue());

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
