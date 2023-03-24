package com.example.observalble;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private BorderPane borderPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/observalble/home.fxml"));
            try {
                AnchorPane anchorPane = loader.load();
                HomeController controller = loader.getController();
                controller.setBorderPane(borderPane);
                borderPane.setCenter(anchorPane);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
    }

}
