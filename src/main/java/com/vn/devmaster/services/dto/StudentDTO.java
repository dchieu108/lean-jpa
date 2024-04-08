package com.vn.devmaster.services.dto;

import com.vn.devmaster.services.entites.Clazz;
import com.vn.devmaster.services.mapper.ClazzMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {
    private Integer id;
    private String name;
    private String lastName;
    private String firstName;
    private String address;
    private ClazzDTO clazz;
    private float point;

    List<SubjectDTO> subjectDTOS = new ArrayList<>();


}
