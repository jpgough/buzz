package com.buzz;

import com.buzz.domain.Message;

/**
 * Created by jpgough on 16/09/2014.
 */
public interface Buzz {
    void publish(Message message);

    void follows(String user, String follows);

    void getWall(String user);
}
