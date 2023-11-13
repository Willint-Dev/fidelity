package com.fidelity.movil.reports_service.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Querys {
    public static void consultCustimer() {
        Connection connection = Conexion.getConnection();
        try {
            String query = "SELECT * FROM customer";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, "hola");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("customer_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.closeConnection();
        }
    }

    public static void main(String[] args) {
        consultCustimer();
    }
}