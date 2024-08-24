package com.example.SpringSecurity6.service;

import com.example.SpringSecurity6.Model.UserModel;
import com.example.SpringSecurity6.Repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

    @Autowired
    private  JWTService jwtService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    AuthenticationManager authManager;
    public UserModel register(UserModel user){
        user.setPassword(encoder.encode(user.getPassword()));
      return   userRepo.save(user);
    }

    public String verify(UserModel user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()) {

            return jwtService.generateToken(user.getUsername());
        }
        return "Fail";
    }


    public List<UserModel> getAll() {
        return userRepo.findAll();
    }
}
