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


    public List<GroupDto> getGroups() {
        return new ArrayList<>(groupMap.values());
    }
}
