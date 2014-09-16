package com.buzz.console;

import com.buzz.Buzz;
import com.buzz.domain.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleTest {

    @Mock
    private BufferedReader reader;

    @Mock
    private Buzz buzz;

    @Mock
    private Clock clock;

    @Test public void
    console_call_buzz_api_with_user_and_message_entered() throws IOException {
        Console console = new Console(reader, clock, buzz);
        when(clock.instant()).thenReturn(Instant.now());
        when(clock.getZone()).thenReturn(ZoneId.of("Europe/London"));

        Message message = new Message("Jim", "Hello World", ZonedDateTime.now(clock));
        when(reader.readLine()).thenReturn("Jim -> Hello World");
        console.parseLine();
        verify(buzz).publish(argThat(new IsMatchingMessage(message)));
    }
}

class IsMatchingMessage extends ArgumentMatcher<Message> {

    private Message message;

    protected IsMatchingMessage(Message message) {
        this.message = message;
    }

    @Override
    public boolean matches(Object o) {
        if (!(o instanceof Message)) {
            return false;
        }
        Message other = (Message) o;
        if(! message.getMessage().equals(other.getMessage())) {
            return false;
        }
        if(! message.getUser().equals(other.getUser())) {
            return false;
        }
        if(! message.getTime().equals(other.getTime())) {
            return false;
        }
        return true;
    }
}


