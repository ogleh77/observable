package com.example.salmaan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {


        // TODO: 01/03/2023  Pending database and pending  view insha Allah


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/salmaan/views/customer-info.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        //  CustomerInfoController controller = fxmlLoader.getController();
//        var user = new Users("Ahmed", "Mire", "4303923", "Male",
//                "afternoon", "jamko", "1122", null, "admin");
//
//        //System.out.println("Before \n" + CustomerService.fetchAllCustomer(user));
//        controller.setCustomer(CustomerService.fetchAllCustomer(user).get(0));
//
//        System.out.println(CustomerService.fetchAllCustomer(user).get(0));
//        controller.setActiveUser(user);
//        controller.setCurrentGym(GymService.getGym());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}