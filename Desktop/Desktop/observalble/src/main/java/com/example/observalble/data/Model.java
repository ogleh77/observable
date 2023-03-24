package com.example.observalble.data;

import com.example.observalble.conn.IConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Model {
    public static Connection connection = IConnection.getConnection();
    private static ObservableList<Student> students;

    public static void insert(Student student) throws SQLException {
        String insertQuery = "INSERT INTO customers(name, age) VALUES (?,?)";

        PreparedStatement ps = connection.prepareStatement(insertQuery);
        ps.setString(1, student.getName());
        ps.setInt(2, student.getAge());

        ps.executeUpdate();
        ps.close();
        System.out.println("Inserted");
    }

    public static void backUp(String path) throws SQLException {

        Statement statement = connection.createStatement();


        if (!path.equals(location()) || location() == null) {
            String backupLocationQuery = "INSERT INTO backup(location) VALUES('" + path + "')";
            statement.addBatch(backupLocationQuery);
        }
        String query = "BACKUP to " + path + "/backup.db";
        System.out.println(query);
        //statement.addBatch(query);
        statement.executeUpdate(query);
        System.out.println("Backup-ed");
    }

    public static void restore() throws SQLException {

        Statement statement = connection.createStatement();


    }


    public static ObservableList<Student> studentList() {
        if (students == null) {
            students = FXCollections.observableArrayList();
            for (int i = 0; i < 10; i++) {
                Student student = new Student("Student " + i, i * 10);
                students.add(student);
            }
        }
        System.out.println("I returned "+students.hashCode());
        return students;
    }
}
