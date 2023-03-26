package com.example.observalble.controllers;

import com.example.observalble.data.Student;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private TableColumn<Student, String> stName;

    @FXML
    private TableColumn<Student, String> stName1;
    @FXML
    private ListView<Student> listView;
    @FXML
    private TableView<Student> tbView;
    private ObservableList<Student> students = FXCollections.observableArrayList();

    @FXML
    void updateHandler() throws IOException {

        if (tbView.getSelectionModel().getSelectedItem() != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/observalble/update.fxml"));
            Scene scene = new Scene(loader.load());
            UpdateController controller = loader.getController();
            controller.setStudent(tbView.getSelectionModel().getSelectedItem());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
    }


    private void data() {
        for (int i = 0; i < 10; i++) {
            Student student = new Student("Student " + i, (int) (Math.random() * 100));
            students.add(student);
        }
    }

    private void initTable() {
        data();
        System.out.println("called init method in home");
        stName.setCellValueFactory(new PropertyValueFactory<>("name"));
        stName1.setCellValueFactory(new PropertyValueFactory<>("age"));
        listView.setItems(students);
        tbView.setItems(students);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(this::initTable);
    }
}
