package com.thoughtworks.capability.gtb.restfulapidesign.Controller;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.StudentDto;
import com.thoughtworks.capability.gtb.restfulapidesign.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/users/{gender}")
    public ResponseEntity<List<StudentDto>> getUsers (@PathVariable("gender") String gender){
        if (gender == null){
            return ResponseEntity.ok().body(studentService.getStudentByGender(gender));
        }
        return ResponseEntity.ok().body(studentService.getStudent());
    }

}
