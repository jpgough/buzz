package com.buzz.domain;


import java.time.ZonedDateTime;

public class Message {
    private String user;
    private String message;
    private ZonedDateTime time;

    public Message(String user, String message, ZonedDateTime time) {
        this.user = user;
        this.message = message;
        this.time = time;
    }

    public String getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public ZonedDateTime getTime() {
        return time;
    }

}
