module com.example.observalble {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.observalble to javafx.fxml;
    exports com.example.observalble;
}