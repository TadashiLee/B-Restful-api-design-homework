package com.thoughtworks.capability.gtb.restfulapidesign.Controller;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.GroupDto;
import com.thoughtworks.capability.gtb.restfulapidesign.Service.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/groups")
    public ResponseEntity<List<GroupDto>> getGroups(){
        return ResponseEntity.ok().body(groupService.getGroups());
    }
}
