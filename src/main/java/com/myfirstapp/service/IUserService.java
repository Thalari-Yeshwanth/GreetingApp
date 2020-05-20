package com.myfirstapp.service;


import com.myfirstapp.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User addUser(User user);

    Optional<User> getUsersById(long id);

    List<User> getAllUsers();

    String deleteUser(long id);

}
