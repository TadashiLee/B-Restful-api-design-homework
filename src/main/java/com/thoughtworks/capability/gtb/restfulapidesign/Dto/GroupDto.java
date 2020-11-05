package com.thoughtworks.capability.gtb.restfulapidesign.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {
    Integer id;
    String name;
    String note;
}
