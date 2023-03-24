package com.example.observalble;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ValiditionController implements Initializable {
    @FXML
    private TextField discount;
    private final double max = 1.9;
    private final double salary = 4;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        discount.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                discount.setText(newValue.replaceAll("[^\\d\\.?}]", ""));
            }
            if (!discount.getText().isBlank()) {
                double _discount = Double.parseDouble(discount.getText());
                if (_discount > max) {
                    System.out.println("Discoun't cna gret han max " + max);
                } else {
                    System.out.println("Good");
                }
                System.out.println(_discount);
            }
        });


    }

    @FXML
    void btnHandler() {
        double money = salary - (!discount.getText().isEmpty() ||
                !discount.getText().isBlank() ? Double.parseDouble(discount.getText()) : 0);

        System.out.println(money);

    }


}
