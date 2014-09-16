package com.buzz;

import com.buzz.dao.MessageDao;
import com.buzz.dao.UserDao;
import com.buzz.domain.Message;

import java.util.List;


public class Buzz {

    private UserDao userDao;
    private MessageDao messageDao;

    public Buzz(UserDao userDao, MessageDao messageDao) {
        this.userDao = userDao;
        this.messageDao = messageDao;
    }

    public void publish(Message message) {
        if(! userDao.userExists(message.getUser())) {
            userDao.addUser(message.getUser());
        }
        messageDao.store(message);
    }

    public void follows(String user, String follows) {

    }

    public List<String> getWall(String user) {
        return null;
    }

    public List<String> getTimeline(String user) {
        return null;
    }
}
