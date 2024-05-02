package org.alexis;

import org.alexis.Services.MessagesServices;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("App message");
            System.out.println("***** MENU *****");
            System.out.println("1. Create message");
            System.out.println("2. Search messages");
            System.out.println("3. Edit message");
            System.out.println("4. Delete message");
            System.out.println("5. Exit");
            opcion = scanner.nextInt();
            System.out.println("-----------------------------------------------------------------");
            switch (opcion) {
                case 1:
                    MessagesServices.createMessage();
                    break;
                case 2:
                    MessagesServices.getMessages();
                    break;
                case 3:
                    MessagesServices.editMessage();
                    break;
                case 4:
                    MessagesServices.removeMessage();
                    break;
                default:
                    break;
            }

        } while (opcion != 5);
    }
}