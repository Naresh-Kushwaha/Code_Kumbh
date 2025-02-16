package com.example.SpringSecurity6.Controller;

import com.example.SpringSecurity6.Model.Alumni;
import com.example.SpringSecurity6.service.AlumniService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumni")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ALUMNI')")
public class AlumniController {
    private final AlumniService service;

    @GetMapping("/greet")
    public String greet(){
        return service.greet();
    }
    @GetMapping
    public ResponseEntity<Alumni> getAlumni(){
        return  ResponseEntity.ok(service.getAlumni());
    }
    @PutMapping
    public ResponseEntity<String >updateAlumni(@RequestBody Alumni alumni){
        return ResponseEntity.ok(service.updateAlumni(alumni));
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteAlumni(){
        service.deleteStudent();
        return ResponseEntity.noContent().build();
    }

}
