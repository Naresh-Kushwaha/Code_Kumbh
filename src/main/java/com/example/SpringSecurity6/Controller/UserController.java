package com.example.SpringSecurity6.Controller;


import com.example.SpringSecurity6.Model.UserModel;
import com.example.SpringSecurity6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public  String Home(){
        return "hello";

    }
    @PostMapping("/register")
    public UserModel register(@RequestBody UserModel user){
        return userService.register(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody UserModel user){
        return userService.verify(user);
    }
    @GetMapping("/user")
    public List<UserModel> getAll(){
        return userService.getAll();
    }
}
