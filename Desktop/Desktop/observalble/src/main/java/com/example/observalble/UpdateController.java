package com.example.observalble;

import com.example.observalble.data.Model;
import com.example.observalble.data.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class UpdateController {
    @FXML
    private TextField name;
    private Student student;
    @FXML
    private BorderPane borderPane;

    @FXML
    void updateHandler() throws IOException {
        student.setName(name.getText());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/observalble/home.fxml"));
        AnchorPane anchorPane = loader.load();
        HomeController controller = loader.getController();
        controller.setBorderPane(borderPane);
        borderPane.setCenter(anchorPane);
    }

    @FXML
    void insertHandler() throws IOException {
        Student students = new Student(name.getText(), 120);
        Model.studentList().add(students);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/observalble/home.fxml"));
        AnchorPane anchorPane = loader.load();
        HomeController controller = loader.getController();
        controller.setBorderPane(borderPane);
        borderPane.setCenter(anchorPane);
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }
}
