module com.example.observalble {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.xerial.sqlitejdbc;
    requires java.sql;

    opens com.example.observalble to javafx.fxml;
    opens com.example.observalble.controllers to javafx.fxml;
    exports com.example.observalble.data;
    exports com.example.observalble;

}