/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guisql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rafae
 */
public class DatabaseConnection {
    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Northwind;integratedSecurity=true;encrypt=false;";

    private static final String USER = "";      // kosongkan jika pakai integratedSecurity
    private static final String PASS = "";      // kosongkan jika pakai integratedSecurity

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}

