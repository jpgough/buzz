package com.buzz.console;

public class CommandNotRecognisedException extends Exception {
    public CommandNotRecognisedException(String message) {
        super(message);
    }
}
