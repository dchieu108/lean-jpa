package com.vn.devmaster.services.mapper;

import com.vn.devmaster.services.dto.StudentDTO;
import com.vn.devmaster.services.entites.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.fasterxml.jackson.databind.util.ClassUtil.name;
@RequiredArgsConstructor
@Component
public class StudentMapper implements EntityMapper<Student, StudentDTO> {
    private final ClazzMapper clazzMapper;
    @Override
    public Student toEntity(StudentDTO dto) {
        return null;
    }

    @Override
    public StudentDTO toDto(Student entity) {
        return StudentDTO
                .builder()
                .id(entity.getId())
                .name(entity.getLastName()+ "" +entity.getFirstName())
                .address(entity.getAddress())
//                .clazz(clazzMapper.toDto(entity.getClazz()))
                .build();
    }

    @Override
    public List<Student> toEntity(List<StudentDTO> dto) {
        return null;
    }

    @Override
    public List<StudentDTO> toDto(List<Student> entity) {
        return null;
    }
}
