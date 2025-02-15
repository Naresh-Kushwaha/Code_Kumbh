package com.example.SpringSecurity6.Repo;

import com.example.SpringSecurity6.Model.Alumni;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AlumniRepo extends MongoRepository<Alumni,String> {
  Optional<List<Alumni>> findByCareerInterest(String interest);
   Optional<List<Alumni>> findByIndustry(String interest);
}
