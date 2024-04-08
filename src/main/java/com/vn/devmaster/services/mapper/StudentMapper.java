package com.vn.devmaster.services.mapper;

import com.vn.devmaster.services.dto.StudentDTO;
import com.vn.devmaster.services.entites.Student;
import com.vn.devmaster.services.repositiory.StudentRepositiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.databind.util.ClassUtil.name;
@Component
public class StudentMapper implements EntityMapper<Student, StudentDTO> {
    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public  Student toEntity(StudentDTO dto) {
        return Student
                .builder()
                .id(dto.getId())
                .address(dto.getAddress())
                .firstName(dto.getName())
                .lastName(dto.getName())
                .clazz(clazzMapper.toEntity(dto.getClazz()))
                .build();
    }

    @Override
    public StudentDTO toDto(Student entity) {
        return StudentDTO
                .builder()
                .id(entity.getId())
                .name(entity.getLastName()+ "" +entity.getFirstName())
                .address(entity.getAddress())
                .clazz(clazzMapper.toDto(entity.getClazz()))
                .subjectDTOS(subjectMapper.toDto(entity.getSubjects()))
                .build();
    }

    @Override
    public List<Student> toEntity(List<StudentDTO> dto) {
        return null;
    }

    @Override
    public List<StudentDTO> toDto(List<Student> entity) {
        List<StudentDTO> dtos =new ArrayList<>();
        entity.forEach(student -> {
            StudentDTO studentDTO = toDto(student);
            dtos.add(studentDTO);
        });
        return dtos;
    }
}
