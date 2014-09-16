package com.buzz.domain;


import java.time.ZonedDateTime;

public class Message {
    private User user;
    private String message;
    private ZonedDateTime time;

    public Message(User user, String message, ZonedDateTime time) {
        this.user = user;
        this.message = message;
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public ZonedDateTime getTime() {
        return time;
    }

}
