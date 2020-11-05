package com.thoughtworks.capability.gtb.restfulapidesign.Service;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private Map<Integer, StudentDto> studentMap = new HashMap<>();

    public StudentService(){
        studentMap.put(1, new StudentDto(1, "lucky", "male", "12"));
        studentMap.put(2, new StudentDto(2, "lili", "female", "23"));
        studentMap.put(3, new StudentDto(3, "bob", "male", "35"));
        studentMap.put(4, new StudentDto(4, "tracy", "female", "48"));
    }

    public List<StudentDto> getStudent() {
        Collection<StudentDto> studentDtoCollection = studentMap.values();
        ArrayList<StudentDto> studentDtos = new ArrayList<>(studentDtoCollection);
        return studentDtos;
    }

    public List<StudentDto> getStudentByGender(String gender) {
        Collection<StudentDto> studentDtoCollection = studentMap.values();
        ArrayList<StudentDto> studentDtos = new ArrayList<>(studentDtoCollection);
        List<StudentDto> studentDtosByGender = studentDtos.stream().filter(studentDto -> studentDto.getGender().equals(gender)).collect(Collectors.toList());
        return studentDtosByGender;
    }
}
