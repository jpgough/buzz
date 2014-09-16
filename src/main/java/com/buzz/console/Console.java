package com.buzz.console;

import com.buzz.Buzz;
import com.buzz.domain.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.Clock;
import java.time.ZonedDateTime;

public class Console {

    private final static String PUBLISH = "->";
    private final static String FOLLOWS = "follows";
    private final static String WALL = "wall";
    private BufferedReader reader;
    private Clock clock;
    private Buzz buzz;

    public Console(BufferedReader reader, Clock clock, Buzz buzz) {
        this.reader = reader;
        this.clock = clock;
        this.buzz = buzz;
    }

    protected void parseLine() throws IOException {
        String command = reader.readLine();
        if(command.contains(PUBLISH)) {
            String[] arguments = command.split(PUBLISH);
            Message message = new Message(arguments[0].trim(),
                    arguments[1].trim(),
                    ZonedDateTime.now(clock));
            buzz.publish(message);
        } else if(command.contains(FOLLOWS)) {
            String[] users = command.split(FOLLOWS);
            buzz.follows(users[0].trim(), users[1].trim());
        } else if(command.contains(WALL)) {
            String[] user = command.split(" ");
            buzz.getWall(user[0]);
        }
    }
}
