package com.vn.devmaster.services.service;

import com.vn.devmaster.services.dto.StudentDTO;
import com.vn.devmaster.services.entites.Student;
import com.vn.devmaster.services.mapper.StudentMapper;
import com.vn.devmaster.services.repositiory.StudentRepositiory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class StudentService {
    @Autowired
    private StudentRepositiory studentRepository;

    private final StudentRepositiory studentRepositiory;
    private final StudentMapper studentMapper;

    public List<Student> findAll(){
        List<Student> students = studentRepository.findAll();
        return students;
    }


    // tìm sinh viên theo địa chỉ
    public List<Student> findByAddress(String address){
        List<Student >students =studentRepository.findByAddress(address);
        return students;
    }
    // tìm sinh viên có điểm cao nhất
    public List<Student> findByPoint(String point){
      List<Student >students =studentRepository.findByPoint(point);
        return students;
    }

    // tìm sinh viên có điểm nhỏ hơn 5
    public List<Student> findByPoint1(String point){
        List<Student >students =studentRepository.findByPoint1(point);
        return students;
    }
    public Student findById(int id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isEmpty()){
            System.out.println("Không tìm thấy sinh viên");
            return null;
        }
        return optionalStudent.get();
    }
    // thêm sinh viên
//    public String save(StudentDTO studentDTO){
//        Student student = new Student();
//        student.setLastName(studentDTO.getLastName());
//        student.setFirstName(studentDTO.getFirstName());
//        student.setAddress(studentDTO.getAddress());
//        student.setClazz(studentDTO.getClazz());
//        studentRepository.save(student);
//        return "Thêm thành công";
//    }
    // sửa sinh viên theo id
//    public String update(int id, StudentDTO studentDTO) {
//        boolean existsById = studentRepository.existsById(id);
//        if (!existsById) return "Không có sinh viên có id = " +id;
//
//        Student student = new Student();
//        student.setId(id);
//        student.setLastName(studentDTO.getLastName());
//        student.setFirstName(studentDTO.getFirstName());
//        student.setAddress(studentDTO.getAddress());
//        student.setClazz(studentDTO.getClazz());
//        studentRepository.save(student);
//        return "Cập nhật thành công";
//    }

    // xóa sinh viên

    public String delete (int id){
        boolean existsById = studentRepository.existsById(id);
        if (!existsById) return "Không có sinh viên có id = " +id;

        studentRepository.deleteById(id);
        return "Xóa thành công";
    }
}
