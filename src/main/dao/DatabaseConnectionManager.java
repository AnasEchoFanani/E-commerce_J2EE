package main.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {
    private String jdbcUrl = "jdbc:mysql://localhost:3306/miniproject2";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
    }
}
