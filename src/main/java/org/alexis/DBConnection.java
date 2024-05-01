package org.alexis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private String url = "jdbc:mysql://localhost:3306";
    private String db_user = "root";
    private String db_password = "NFMpjTahuttTaEYZKvrBRZjh9";
    private Connection conn;

    public Connection get_connection() {
        try {
            this.conn = DriverManager.getConnection(this.url, this.db_user, this.db_password);
            if (this.conn != null) {
                System.out.println("Connection successfully established");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return this.conn;
    }

}
