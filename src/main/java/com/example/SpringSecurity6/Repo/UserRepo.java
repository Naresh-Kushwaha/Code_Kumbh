package com.example.SpringSecurity6.Repo;

import com.example.SpringSecurity6.Model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<UserModel,String> {


    UserModel findByUsername(String username);
}

