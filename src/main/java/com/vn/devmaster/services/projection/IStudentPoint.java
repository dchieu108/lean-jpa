package com.vn.devmaster.services.projection;

import com.vn.devmaster.services.dto.ClazzDTO;
import com.vn.devmaster.services.dto.SubjectDTO;

import java.util.List;

public interface IStudentPoint {
    String getName();
    String getAddress();
    ClazzDTO getClazzName();
    List<SubjectDTO> getSubjectName();
    float getPoint();

    int getId();



}
