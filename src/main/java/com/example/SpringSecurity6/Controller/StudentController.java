package com.example.SpringSecurity6.Controller;

import com.example.SpringSecurity6.Model.Alumni;
import com.example.SpringSecurity6.Model.Student;
import com.example.SpringSecurity6.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student")
@PreAuthorize("hasAuthority('STUDENT')")
public class StudentController {
    private final StudentService service;
    @GetMapping("/greet")
     public String greet(){
         return service.greet();
     }
     @GetMapping
    public ResponseEntity<Student> getStudent(){
        return ResponseEntity.ok(service.getStudent());
     }
     @PutMapping
    public ResponseEntity<String> updateStudent(@RequestBody Student student){
        return ResponseEntity.ok(service.updateStudent(student));

     }
     @GetMapping("career/{career}")
     public ResponseEntity<List<Alumni>> getByCareer(@PathVariable String career){
        return ResponseEntity.ok(service.getByCareerInterest(career));
     }
    @GetMapping("industry/{industry}")
    public ResponseEntity<List<Alumni>> getByIndustry(@PathVariable String industry){
        return ResponseEntity.ok(service.getByIndustry(industry));
    }
     @DeleteMapping
    public ResponseEntity<Void> deleteStudent(){
        service.deleteStudent();
        return ResponseEntity.noContent().build();
     }
}
