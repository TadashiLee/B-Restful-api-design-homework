package com.thoughtworks.capability.gtb.restfulapidesign.Service;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {

    Map<Integer, StudentDto> studentMap = new HashMap<>();

    public StudentService(){
        studentMap.put(1, new StudentDto(1, "lucky", "male", "12"));
        studentMap.put(2, new StudentDto(2, "lili", "female", "23"));
        studentMap.put(3, new StudentDto(3, "bob", "male", "35"));
        studentMap.put(4, new StudentDto(4, "tracy", "female", "48"));
        studentMap.put(5, new StudentDto(5, "durant", "male", "12"));
        studentMap.put(6, new StudentDto(6, "adil", "female", "23"));
        studentMap.put(7, new StudentDto(7, "linda", "male", "35"));
        studentMap.put(8, new StudentDto(8, "lee", "female", "48"));
    }

    public void addStudent(StudentDto studentDto) {
        studentDto.setId(studentMap.size()+1);
        studentMap.put(studentMap.size()+1,studentDto);
    }

    public List<StudentDto> getStudents() {
        return new ArrayList<>(studentMap.values());
    }

    public List<StudentDto> getStudentsByGender(String gender) {
        ArrayList<StudentDto> studentDtos = new ArrayList<>(studentMap.values());
        List<StudentDto> studentDtosByGender = studentDtos.stream().filter(studentDto -> studentDto.getGender().equals(gender)).collect(Collectors.toList());
        return studentDtosByGender;
    }

    public boolean deleteStudent(Integer id) {
        if (studentMap.containsKey(id)){
            studentMap.remove(id);
            return true;
        }
        return false;
    }

    public StudentDto getStudentById(Integer id) {
        return studentMap.get(id);
    }

    public boolean refreshStudents(StudentDto studentDto) {
        if (studentMap.containsKey(studentDto.getId())){
            StudentDto student = studentMap.get(studentDto.getId());
            student.setName(studentDto.getName());
            student.setGender(studentDto.getGender());
            student.setNote(studentDto.getNote());
            return true;
        }
        return false;
    }
}
