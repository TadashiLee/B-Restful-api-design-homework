package com.thoughtworks.capability.gtb.restfulapidesign.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    Integer id;
    String name;
    String gender;
    String note;
}
