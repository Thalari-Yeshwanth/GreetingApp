package com.myfirstapp.controller;
import com.myfirstapp.model.User;
import com.myfirstapp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping(value ={"","/", "/home"})
    public String user() {
        return "Welcome users";

    }

    @PostMapping("/add")
    public User userAdd(@RequestBody User user){
        return iUserService.addUser(user);
    }

    @PostMapping("/post")
    public User getUser(@RequestBody User user){
        return iUserService.addUser(user);

    }

    @GetMapping("/getUsers/{id}")
    public Optional<User> getUsersById(@PathVariable(value = "id")long id){

        return iUserService.getUsersById(id);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers()
    {
        return iUserService.getAllUsers();
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") long id){
        iUserService.deleteUser(id);
    }

}
