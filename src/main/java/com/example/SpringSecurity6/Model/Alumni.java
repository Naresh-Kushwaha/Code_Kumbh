package com.example.SpringSecurity6.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Alumni  {
    @Id
    private String id;
    private String name;
    private String careerInterest;
    private String industry;
    private int yoe;
    private List<String> skills;

}
