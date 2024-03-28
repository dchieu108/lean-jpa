package com.vn.devmaster.services.projection;

import com.vn.devmaster.services.dto.ClazzDTO;

public interface IStudentPoint {
    String getName();
    String getAddress();
    ClazzDTO getClazzName();
    String getSubjectName();
    float getPoint();

    int getId();



}
