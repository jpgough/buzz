package com.buzz.console;

import com.buzz.Buzz;
import com.buzz.domain.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.Clock;
import java.time.ZonedDateTime;

public class Console {

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
        if(command.contains("->")) {
            String[] arguments = command.split("->");
            Message message = new Message(arguments[0].trim(), arguments[1].trim(),
                    ZonedDateTime.now(clock));
            buzz.publish(message);
        }
    }
}
