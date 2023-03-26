package com.example.observalble.controllers;

import com.example.observalble.data.Student;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class UpdateController {



    private Student student;

    @FXML
    private TextField name;
    @FXML
    private TextField ageTxt;


    @FXML
    void ageHandler() {

    }

    @FXML
    void updateHandler() {
        this.student.setName(name.getText());
        this.student.setAge(Integer.parseInt(ageTxt.getText()));
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
