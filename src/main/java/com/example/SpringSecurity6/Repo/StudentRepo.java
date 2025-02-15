package com.example.SpringSecurity6.Repo;
import com.example.SpringSecurity6.Model.Student;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends MongoRepository<Student,String> {

}
