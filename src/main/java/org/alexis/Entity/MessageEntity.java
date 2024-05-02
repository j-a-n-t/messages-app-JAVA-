package org.alexis.Entity;

import java.sql.Timestamp;

public class MessageEntity {

    private int id;
    private String message;
    private String message_author;
    private Timestamp message_date;


    public MessageEntity() {
    }
    public MessageEntity(String message, String message_author, Timestamp message_date) {
        this.message = message;
        this.message_author = message_author;
        this.message_date = message_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage_author() {
        return message_author;
    }

    public void setMessage_author(String message_author) {
        this.message_author = message_author;
    }

    public Timestamp getMessage_date() {
        return message_date;
    }

    public void setMessage_date(Timestamp message_date) {
        this.message_date = message_date;
    }
}
