package com.buzz.dao;

import com.buzz.domain.User;

public interface UserDao {
    boolean userExists(User user);

    void addUser(User user);
}
