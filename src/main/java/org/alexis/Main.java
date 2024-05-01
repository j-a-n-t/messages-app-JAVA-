package org.alexis;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        DBConnection dbConnection = new DBConnection();

        try (Connection connection = dbConnection.get_connection()) {} catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}