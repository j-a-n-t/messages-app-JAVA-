package org.alexis.DAO;

import org.alexis.DBConnection;
import org.alexis.Entity.MessageEntity;

import java.sql.*;

public class MessageDAO {

    public static String createMessage(MessageEntity message) {
        DBConnection dbConnection = new DBConnection();
        try (Connection connection = dbConnection.getCconnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO coloso.message VALUES (default,?,?,?)");
            statement.setString(1, message.getMessage());
            statement.setString(2, message.getMessage_author());
            statement.setTimestamp(3, message.getMessage_date());
            int rowAffected = statement.executeUpdate();
            return rowAffected > 0 ? "message saved" : "message not saved";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getMessages() {
        DBConnection dbConnection = new DBConnection();
        try (Connection connection = dbConnection.getCconnection()) {
            ResultSet result = null;
            PreparedStatement statement = null;
            statement = connection.prepareStatement("SELECT * FROM coloso.message");
            result = statement.executeQuery();
            while (result.next()) {
                System.out.println("ID: " + result.getString("message_id"));
                System.out.println("Author: " + result.getString("message_author"));
                System.out.println("Message: " + result.getString("message"));
                System.out.println("Date: " + result.getString("message_date"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String removeMessage(int message_id) {
        DBConnection dbConnection = new DBConnection();
        try (Connection connection = dbConnection.getCconnection()) {
            ResultSet result = null;
            PreparedStatement statement = null;
            statement = connection.prepareStatement("SELECT * FROM coloso.message WHERE message_id=?");
            statement.setInt(1, message_id);
            result = statement.executeQuery();
            if (!result.next()) return "invalid id";

            statement = connection.prepareStatement("DELETE FROM coloso.message WHERE(message_id = ?)");
            statement.setInt(1, message_id);
            int affectedRow = statement.executeUpdate();
            return affectedRow < 0 ? "row not deleted" : "row deleted";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String editMessage(MessageEntity message) {
        DBConnection dbConnection = new DBConnection();
        try (Connection connection = dbConnection.getCconnection()) {
            ResultSet result = null;
            PreparedStatement statement = null;
            statement = connection.prepareStatement("SELECT * FROM coloso.message WHERE message_id=?");
            statement.setInt(1, message.getId());
            result = statement.executeQuery();
            if (!result.next()) return "invalid id";

            String queries = "UPDATE  coloso.message SET message=?,  message_author=?, message_date=? WHERE message_id =?";
            statement = connection.prepareStatement(queries);
            statement.setString(1, message.getMessage());
            statement.setString(2, message.getMessage_author());
            statement.setTimestamp(3, message.getMessage_date());
            statement.setInt(4, message.getId());
            int affectedRow = statement.executeUpdate();
            return affectedRow < 0 ? "row not edit" : "row edit";

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
