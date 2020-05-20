package com.myfirstapp.service;
import com.myfirstapp.model.Greeting;
import com.myfirstapp.model.User;
import com.myfirstapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class IGreetingServiceImpl implements IGreetingService {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;

    @Override
    public Greeting postGreeting(User user) {
        String message = String.format(template,(user.toString().isEmpty())? "Hello World" : user.toString());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(),message));
    }

    @Override
    public Optional<Greeting> getGreetingById(long id) {
        return greetingRepository.findById(id);
    }

    @Override
    public List<Greeting> getAllGreetings() {
        List<Greeting> greetings = new ArrayList<>();
        greetingRepository.findAll().forEach(greeting -> greetings.add(greeting));
        return greetings;
    }

    @Override
    public void deleteGreeting(long id) {
        greetingRepository.deleteById(id);
    }

    @Override
    public Optional<Greeting> updateGreeting(long id, String name) {
        Optional<Greeting> greeting = greetingRepository.findById(id);
        greeting.get().setMessage(name);
        return greeting;

    }
}
