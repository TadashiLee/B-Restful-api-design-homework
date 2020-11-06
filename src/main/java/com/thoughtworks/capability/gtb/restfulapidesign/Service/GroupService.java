package com.thoughtworks.capability.gtb.restfulapidesign.Service;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.GroupDto;
import com.thoughtworks.capability.gtb.restfulapidesign.Dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GroupService {


    private Map<Integer, GroupDto> groupMap = new HashMap<>();

    private final StudentService studentService;

    public GroupService(StudentService studentService){
        this.studentService = studentService;
//        this.groupStudents();
    }

//    private void groupStudents() {
//        List<List<StudentDto>> res = new ArrayList<>();
//        int num = studentService.studentMap.size() / 6;
//        int remain = studentService.studentMap.size() % 6;
//        List<StudentDto> studentDtos = new ArrayList<>(studentService.studentMap.values());
//        for(int i = 0; i < num * 6; i += num) {
//            List<StudentDto> group = new ArrayList<>(studentDtos.subList(i, i + num));
//            group.sort((o1, o2) -> o1.getId() - o2.getId());
//            res.add(group);
//        }
//
//        for(int i = 0; i < remain; ++i) {
//            res.get(i).add(studentDtos.get(num * 6 + i));
//            res.get(i).sort((o1, o2) -> o1.getId() - o2.getId());
//        }
//        return res;
//    }

    public List<GroupDto> getGroups() {
        return new ArrayList<>(groupMap.values());
    }

    public boolean refreshGroups(GroupDto groupDto) {
        if(groupMap.containsKey(groupDto.getId())){
            groupMap.get(groupDto.getId()).setName(groupDto.getName());
            return true;
        }
        return false;
    }
}
