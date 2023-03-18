package com.example.observalble.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Data {

    public static ObservableList<Students> data() {

        ObservableList<Students> students = FXCollections.observableArrayList();

        for (int i = 0; i < 5; i++) {
            Students student = new Students("Student " + i, (int) (Math.random() * 100));
            students.add(student);
        }

        return students;
    }
}
