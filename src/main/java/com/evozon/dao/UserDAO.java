package com.evozon.dao;

import com.evozon.domain.User;

import java.util.List;

public interface UserDAO {

    void addUser(User user);

    void addDefaultUsers();

    List<User> getAllUsers();

}
