package com.example.SpringSecurity6.service;
import com.example.SpringSecurity6.Model.Alumni;
import com.example.SpringSecurity6.Model.Student;
import com.example.SpringSecurity6.Repo.AlumniRepo;
import com.example.SpringSecurity6.Repo.StudentRepo;
import com.example.SpringSecurity6.Repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;
    private final AlumniRepo alumniRepo;
   private final UserRepo userRepo;
    public String greet(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        return "hii this is student service"+authentication.getName();
    }

    public Student getStudent(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String student=authentication.getName();

        return studentRepo.findById(student).orElse(null);
    }
    public List<Alumni> getByCareerInterest(String interest){
        return alumniRepo.findByCareerInterest(interest).orElse(null);
    }
    public List<Alumni> getByIndustry(String interest){
        return alumniRepo.findByIndustry(interest).orElse(null);
    }

    public String updateStudent(Student student){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        student.setId(authentication.getName());
        studentRepo.save(student);
        return "Student Profile Created";
    }
    public String deleteStudent(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        userRepo.deleteById(authentication.getName());
        studentRepo.deleteById(authentication.getName());
        return "Account Deleted Successfully";
    }


}