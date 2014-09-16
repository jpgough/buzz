package com.buzz.dao;

import com.buzz.domain.Message;

public interface MessageDao {
    void store(Message message);
}
