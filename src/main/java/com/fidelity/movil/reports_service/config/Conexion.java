package com.fidelity.movil.reports_service.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection connection;
    private static final String jdbcUrl = "jdbc:postgresql://localhost:5432/vitality";
    private static final String username = "postgres";
    private static final String password = "123456";

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(jdbcUrl, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Error al establecer la conexión a la base de datos");
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}