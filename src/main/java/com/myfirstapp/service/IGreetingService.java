package com.myfirstapp.service;

import com.myfirstapp.model.Greeting;
import com.myfirstapp.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IGreetingService {
    Greeting postGreeting(User user);
    Optional<Greeting> getGreetingById(long id);
    List<Greeting> getAllGreetings();
    void deleteGreeting(long id);
    Optional<Greeting> updateGreeting(long id, String name);

}
