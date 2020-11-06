package com.thoughtworks.capability.gtb.restfulapidesign.Service;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.GroupDto;
import com.thoughtworks.capability.gtb.restfulapidesign.Dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GroupService {


    private Map<Integer, GroupDto> groupMap = new HashMap<>();
    private String[] groupName = {"Group 1", "Group 2", "Group 3", "Group 4", "Group 5", "Group 6"};

    private final StudentService studentService;

    public GroupService(StudentService studentService){
        this.studentService = studentService;
    }

    private void groupStudents() {
        List<List<StudentDto>> res = new ArrayList<>();
        int num = studentService.studentMap.size() / 6;
        int remain = studentService.studentMap.size() % 6;

        List<StudentDto> studentDtos = new ArrayList<>(studentService.studentMap.values());
        Collections.shuffle(studentDtos);
        for(int i = 0; i < num * 6; i += num) {
            List<StudentDto> group = new ArrayList<>(studentDtos.subList(i, i + num));
            group.sort((o1, o2) -> o1.getId() - o2.getId());
            res.add(group);
        }

        for(int i = 0; i < remain; ++i) {
            res.get(i).add(studentDtos.get(num * 6 + i));
            res.get(i).sort((o1, o2) -> o1.getId() - o2.getId());
        }
        for(int i=0; i< 6; i++){
            groupMap.put(i+1,new GroupDto(i+1, groupName[i],"hi group"+(i+1)+"!",res.get(i)));
        }
    }

    public List<GroupDto> getGroups() {
        this.groupStudents();
        return new ArrayList<>(groupMap.values());
    }

    public GroupDto refreshGroupsName(GroupDto groupDto) {
        if(groupMap.containsKey(groupDto.getId())){
            groupName[groupDto.getId()-1] = groupDto.getName();
            return groupMap.get(groupDto.getId());
        }
        return new GroupDto();
    }
}
