package com.buzz;

import com.buzz.dao.MessageDao;
import com.buzz.dao.UserDao;
import com.buzz.domain.Message;
import com.buzz.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.ZonedDateTime;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BuzzTest {

    @Mock
    private UserDao userDao;

    @Mock
    private MessageDao messageDao;

    @Test public void
    user_can_publish_buzz_when_user_exists() {
        Buzz buzz = new Buzz(userDao, messageDao);
        User expectedUser = new User("Jim");
        Message message = new Message(expectedUser, "Hello World", ZonedDateTime.now());
        when(userDao.userExists(expectedUser)).thenReturn(true);
        buzz.publish(message);
        verify(userDao).userExists(expectedUser);
        verify(messageDao).store(message);
    }

}
