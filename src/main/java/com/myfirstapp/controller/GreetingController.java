package com.myfirstapp.controller;

import com.myfirstapp.model.Greeting;
import com.myfirstapp.model.User;
import com.myfirstapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/greeting")
public class GreetingController {


    @Autowired
    private IGreetingService iGreetingService;

    User user = new User();

    @GetMapping(value ={"","/", "/home"})
    public Greeting greeting(@RequestParam(value = "firstname", defaultValue = "World")String firstname) {
        user.setFirstName(firstname);
        return iGreetingService.postGreeting(user);
    }
    //localhost:8080/greeting/post
    @PostMapping("/post")
    public Greeting getGreeting(@RequestParam(value = "firstName")String firstname){
        user.setFirstName(firstname);
        return iGreetingService.postGreeting(user);

    }
    //localhost:8080/greeting/getGreeting/1
    @GetMapping("/getGreeting/{id}")
    public Optional<Greeting> getGreetingById(@PathVariable(value = "id")long id){
        return iGreetingService.getGreetingById(id);
    }

    //localhost:8080/greeting/getAllGreetings
    @GetMapping("/getAllGreetings")
    public List<Greeting>getAllGreeting(){
        return iGreetingService.getAllGreetings();
    }

    //localhost:8080/greeting/deleteGreeting/1
    @DeleteMapping("/deleteGreeting/{id}")
    public void deletePerson(@PathVariable("id") long id){
        iGreetingService.deleteGreeting(id);
    }

    @PutMapping("/updateGreeting/{id}")
    public Optional<Greeting> updateGreeting(@PathVariable("id")long id,
                                             @RequestParam(value = "name")String name) {
        {
            return iGreetingService.updateGreeting(id, name);
        }
    }

}
