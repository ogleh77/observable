package com.example.observalble;

import com.example.observalble.data.Model;
import com.example.observalble.data.Student;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private TableColumn<Student, String> stName;

    @FXML
    private TableView<Student> tbView;
    private ObservableList<Student> students;
    @FXML
    private BorderPane borderPane;

    @FXML
    void backupHandler(ActionEvent event) throws SQLException {

    }
//        String path = Model.location();
//        File selectedFile;
//        if (path == null) {
//            DirectoryChooser directoryChooser = new DirectoryChooser();
//            selectedFile = directoryChooser.showDialog(null);
//            path = selectedFile.getAbsolutePath();
//        }
//        Model.backUp(path);
//        System.out.println(path);
//    }

    @FXML
    void inserthandler(ActionEvent event) throws SQLException, IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/observalble/update.fxml"));
        AnchorPane anchorPane = loader.load();
        UpdateController controller = loader.getController();
        controller.setStudent(tbView.getSelectionModel().getSelectedItem());
        controller.setBorderPane(borderPane);
        borderPane.setCenter(anchorPane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            System.out.println("Hello");
            students = Model.studentList();
            System.out.println("I Made " + students.hashCode());

            stName.setCellValueFactory(new PropertyValueFactory<>("name"));
            tbView.setItems(students);
        });
    }


    public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }
}
