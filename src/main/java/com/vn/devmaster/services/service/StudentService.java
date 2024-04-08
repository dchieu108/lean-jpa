package com.vn.devmaster.services.service;

import com.vn.devmaster.services.dto.StudentDTO;
import com.vn.devmaster.services.dto.SubjectDTO;
import com.vn.devmaster.services.entites.Clazz;
import com.vn.devmaster.services.entites.Student;
import com.vn.devmaster.services.mapper.ClazzMapper;
import com.vn.devmaster.services.mapper.StudentMapper;
import com.vn.devmaster.services.projection.IStudentPoint;
import com.vn.devmaster.services.repositiory.ClazzRepositiory;
import com.vn.devmaster.services.repositiory.StudentRepositiory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentService {
    @Autowired
    private StudentRepositiory studentRepository;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private ClazzRepositiory clazzRepositiory;


    public List<Student> findAll() {
        List<Student> students = studentRepository.findAll();
        return students;
    }


    // tìm sinh viên theo địa chỉ
    public List<StudentDTO> findByAddress(String address) {
        List<Student> students = studentRepository.findByAddress(address);
        return studentMapper.toDto(students);
    }

    // tìm sinh viên có điểm cao nhất
//    public List<Student> findByPoint(String point){
//      List<Student >students =studentRepository.findByPoint(point);
//        return students;
//    }

    // tìm sinh viên có điểm nhỏ hơn 5
//    public List<Student> findByPoint1(String point){
//        List<Student >students =studentRepository.findByPoint1(point);
//        return students;
//    }

    public Student findById(int id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isEmpty()){
            System.out.println("Không tìm thấy sinh viên");
            return null;
        }
        return optionalStudent.get();
    }
    //thêm sinh viên)
    public String save(StudentDTO student){
        Student students = new Student();
        students.setLastName(student.getLastName());
        students.setFirstName(student.getFirstName());
        students.setAddress(student.getAddress());
        studentRepository.save(students);
        return "Thêm thành công";
    }

    public StudentDTO findStudentById(int id){
        List<IStudentPoint> iStudentPoint = studentRepository.findStudentById(id);
        StudentDTO dto = new StudentDTO();
        dto.setName(iStudentPoint.get(0).getName());
        dto.setPoint(iStudentPoint.get(0).getPoint());
        dto.setAddress(iStudentPoint.get(0).getAddress());

        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        iStudentPoint.forEach(item -> {
            SubjectDTO subjectDTO = new SubjectDTO();
            subjectDTO.setName(item.getName());
            subjectDTO.setPoint(item.getPoint());
            subjectDTO.setAddress(item.getAddress());

        });
        dto.setSubjectDTOS(subjectDTOS);

        return dto;
    }

    // sửa sinh viên theo id
    public String update(int id, StudentDTO studentDTO) {
        boolean existsById = studentRepository.existsById(id);
        if (!existsById) return "Không có sinh viên có id = " +id;

        Student student = new Student();
        student.setId(id);
        student.setLastName(studentDTO.getLastName());
        student.setFirstName(studentDTO.getFirstName());
        student.setAddress(studentDTO.getAddress());
        studentRepository.save(student);
        return "Cập nhật thành công";
    }
        // xóa sinh viên

    public String delete (int id){
        boolean existsById = studentRepository.existsById(id);
        if (!existsById) return "Không có sinh viên có id = " +id;
       studentRepository.deleteById(id);
        return "Xóa thành công";
    }

}


