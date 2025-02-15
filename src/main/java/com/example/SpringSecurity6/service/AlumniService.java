package com.example.SpringSecurity6.service;

import com.example.SpringSecurity6.Model.Alumni;
import com.example.SpringSecurity6.Model.Student;
import com.example.SpringSecurity6.Repo.AlumniRepo;
import com.example.SpringSecurity6.Repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AlumniService {
    private final AlumniRepo alumniRepo;
    private final UserRepo userRepo;

    public String greet(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        return "Alumini service "+authentication.getAuthorities();
    }
    public Alumni getAlumni(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String alumni=authentication.getName();
        return alumniRepo.findById(alumni).orElse(null);
    }

    public String updateAlumni(Alumni alumni){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String name=authentication.getName();
        alumni.setId(name);
        alumniRepo.save(alumni);
        return "Alumni Profile Created";
    }
    public  void deleteStudent(){

        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        userRepo.deleteById(authentication.getName());
        alumniRepo.deleteById(authentication.getName());

    }
}
