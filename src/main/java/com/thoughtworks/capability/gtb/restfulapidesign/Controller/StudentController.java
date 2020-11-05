package com.thoughtworks.capability.gtb.restfulapidesign.Controller;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.StudentDto;
import com.thoughtworks.capability.gtb.restfulapidesign.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> getStudents (@RequestParam(name="gender", required = false) String gender){
        if (gender != null){
            return ResponseEntity.ok().body(studentService.getStudentsByGender(gender));
        }
        return ResponseEntity.ok().body(studentService.getStudents());
    }

    @PostMapping("/students")
    public ResponseEntity addStudents (@RequestBody StudentDto studentDto) {
        studentService.addStudent(studentDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity deleteStudents(@PathVariable(value = "id") Integer id){
        if (studentService.deleteStudent(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
}
