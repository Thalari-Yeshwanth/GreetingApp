package com.myfirstapp.service;
import com.myfirstapp.model.Greeting;
import com.myfirstapp.model.User;
import com.myfirstapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;
    AtomicLong counter = new AtomicLong();

    @Override
    public User addUser(User user) {
        user.setId(counter.incrementAndGet());
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUsersById(long id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users= new ArrayList<>();
        userRepository.findAll().forEach(user -> users.add(user));
        return users;
    }

    @Override
    public String deleteUser(long id) {
        userRepository.deleteById(id);
        return "users Deleted Succesfully";

    }


}
