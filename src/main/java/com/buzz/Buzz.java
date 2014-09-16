package com.buzz;

import com.buzz.domain.Message;


public interface Buzz {
    void publish(Message message);

    void follows(String user, String follows);

    void getWall(String user);

    void getTimeline(String user);
}
