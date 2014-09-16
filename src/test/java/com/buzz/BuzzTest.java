package com.buzz;

import com.buzz.dao.MessageDao;
import com.buzz.dao.UserDao;
import com.buzz.domain.Message;
import com.buzz.domain.User;
import org.junit.Before;
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

    private Buzz buzz;
    private User user;

    @Before
    public void before() {
        buzz = new Buzz(userDao, messageDao);
        user = new User("Jim");
    }

    @Test public void
    user_directly_publishes_buzz_when_user_exists() {
        Message message = new Message(user, "Hello World", ZonedDateTime.now());
        when(userDao.userExists(user)).thenReturn(true);
        buzz.publish(message);
        verify(userDao).userExists(user);
        verify(messageDao).store(message);
    }

    @Test public void
    user_is_added_to_the_system_and_then_buzzes_when_user_does_not_exist() {
        when(userDao.userExists(user)).thenReturn(false);
        Message message = new Message(user, "Hello World", ZonedDateTime.now());
        buzz.publish(message);
        verify(userDao).userExists(user);
        verify(userDao).addUser(user);
        verify(messageDao).store(message);
    }

}
