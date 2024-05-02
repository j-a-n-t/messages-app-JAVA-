package org.alexis.Services;

import org.alexis.DAO.MessageDAO;
import org.alexis.Entity.MessageEntity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;

public class MessagesServices {

    private static final Scanner scanner = new Scanner(System.in);

    public static void createMessage() {
        String author = "";
        String message = "";
        String confirmed = "";

        do {
            System.out.println("message author");
            author = scanner.nextLine();
            System.out.println("whats is your message");
            message = scanner.nextLine();
            System.out.println("Auther messages is  " + author + ", \n" + "the message is : " + message + "\n");
            System.out.println("do you agree with message data? Y/N");
            confirmed = scanner.nextLine();
        } while (confirmed.equalsIgnoreCase("N"));

        Date date = new Date();
        MessageEntity register = new MessageEntity();
        register.setMessage(message);
        register.setMessage_author(author);
        register.setMessage_date(new Timestamp(date.getTime()));
        System.out.println(MessageDAO.createMessage(register));
    }

    public static void getMessages() {
        MessageDAO.getMessages();
    }

    public static void removeMessage() {
        String confirmed = null;
        int selectId = 0;
        do {
            System.out.println("write id message");
            selectId = scanner.nextInt();
            System.out.println("You id message is: " + selectId + " is corrected? Y/N");
            confirmed = scanner.next();
        } while (confirmed.equalsIgnoreCase("N"));
        System.out.println(MessageDAO.removeMessage(selectId));
    }

    public static void editMessage() {
        String selectId = "";
        String message = "";
        String author = "";
        String confirmed = "";
        do {
            System.out.println("write id message");
            selectId = scanner.nextLine();
            System.out.println("message author");
            author = scanner.nextLine();
            System.out.println("whats is your message");
            message = scanner.nextLine();
            System.out.println("ID message is: " + selectId);
            System.out.println("New message is : " + message);
            System.out.println("New Author is : " + author);
            System.out.println("is corrected? Y/N");
            confirmed = scanner.nextLine();
        } while (confirmed.equalsIgnoreCase("N"));
        MessageEntity register = new MessageEntity();
        register.setId(Integer.parseInt(selectId));
        register.setMessage(message);
        register.setMessage_author(author);
        register.setMessage_date(new Timestamp(System.currentTimeMillis()));
        System.out.println(MessageDAO.editMessage(register));
    }

}
