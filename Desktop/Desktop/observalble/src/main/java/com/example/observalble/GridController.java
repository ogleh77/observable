package com.example.observalble;

import com.example.observalble.data.Data;
import com.example.observalble.data.Students;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

public class GridController implements Initializable {
    @FXML
    private Pagination pagination;

    private int column = 0;
    private int row = 0;
    private int perPage = 4;
    private ObservableList<Students> students;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {

        });
    }

    @FXML
    void viewHandler(ActionEvent event) {
        // System.out.println(Data.data());
        students = Data.data();
        Collections.sort(students);
        pagination.setPageFactory(this::createPage);
        pagination.setPageCount(Data.data().isEmpty() ? 0 : students.size());

    }


    private GridPane createPage(int index) {

        int fromPage = perPage * index;
        int toIndex = Math.min(fromPage + perPage, students.size());

        Collections.sort(students);

        GridPane gridView = null;
        try {

            gridView = new GridPane();
            //GridPane.setConstraints(gridView, 1, 1, 1, 1, HPos.RIGHT, VPos.TOP);

            gridView.setPadding(new Insets(40, 50, 10, 50));
            for (int i = fromPage; i < toIndex; i++) {
                if (column == 2) {
                    column = 0;
                    row++;
                }

                HBox hBox = new HBox();
                hBox.setStyle("-fx-background-color: blue");
                hBox.setPrefSize(300, 200);
                hBox.setAlignment(Pos.CENTER);
                GridPane.setMargin(hBox, new Insets(10));
                Label label = new Label("Name:- " + students.get(i).getStudentName() + "----Grade:-" + students.get(i).getGrade());
                label.setFont(new Font(14));
                label.setStyle("-fx-text-fill: white");
                hBox.getChildren().add(label);
                gridView.add(hBox, column++, row);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return gridView;
    }


}
