package com.example.SpringSecurity6.Controller;


import com.example.SpringSecurity6.Model.UserModel;
import com.example.SpringSecurity6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/ask")
    public ResponseEntity<String> askAI(@RequestParam String question) {
        String apiUrl = "https://api.deepseek.com/chat";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestBody = "{\"messages\":[{\"role\":\"user\",\"content\":\"" + question + "\"}]}";
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, String.class);
        return ResponseEntity.ok(response.getBody());
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
