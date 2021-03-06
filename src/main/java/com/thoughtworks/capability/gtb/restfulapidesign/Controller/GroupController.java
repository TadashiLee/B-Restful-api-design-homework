package com.thoughtworks.capability.gtb.restfulapidesign.Controller;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.GroupDto;
import com.thoughtworks.capability.gtb.restfulapidesign.Service.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups/v1")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PatchMapping("/name")
    public ResponseEntity refreshGroupsName(@RequestBody GroupDto groupDto) {
        if (groupService.refreshGroupsName(groupDto).getId() != null){
            return ResponseEntity.ok().body(groupService.refreshGroupsName(groupDto));
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/new-groups")
    public ResponseEntity<List<GroupDto>> refreshGroups(){
        return ResponseEntity.ok().body(groupService.groupStudents());
    }

    @GetMapping
    public ResponseEntity<List<GroupDto>> getGroups() {
        return ResponseEntity.ok().body(groupService.getGroups());
    }
}
