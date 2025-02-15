package com.example.SpringSecurity6.Model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Inherited;

@Data
@Document(collection = "ourUser")
public class UserModel {
    @Id
    private String username;
    private String password;
    private String roles;

}
