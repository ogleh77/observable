module com.example.observalble {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.xerial.sqlitejdbc;
    requires java.sql;

    opens com.example.observalble to javafx.fxml;
    exports com.example.observalble;
    exports com.example.observalble.data;
}