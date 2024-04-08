package com.vn.devmaster.services.controller;

import com.vn.devmaster.services.dto.StudentDTO;
import com.vn.devmaster.services.entites.Student;
import com.vn.devmaster.services.repositiory.StudentRepositiory;
import com.vn.devmaster.services.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepositiory studentRepositiory;


    @GetMapping("")
    public List<Student> findAll() {
        return studentService.findAll();
    }
//@GetMapping("")
//public List<Student> findById(){
//        return studentService.findById(id);
//}

    // tìm kiếm theo địa chỉ
    @GetMapping("/find-by-address")
    List<StudentDTO> findByAddress(@RequestParam("address") String address) {
        return studentService.findByAddress(address);
    }

    //tìm sinh viên có điểm cao nhất
//    @GetMapping("/point")
//    List<Student> findByPoint(@RequestParam("point") String point){
//        return studentService.findByPoint(point);
//    }

    // tìm sinh viên có điểm nhỏ hơn 5
//    @GetMapping("/point1")
//    List<Student> findByPoint1(@RequestParam("point") String point){
//        return studentService.findByPoint1(point);
//    }

    // thêm sinh viên
    @PostMapping("")
    String save(@RequestBody StudentDTO student) {
        String massage = studentService.save(student);
        return massage;
    }
    //sửa sinh viên theo id
    @PutMapping("")
    String update(@RequestParam("id")int id, @RequestBody StudentDTO studentDTO){
        String message = studentService.update(id, studentDTO);
        return message;
    }

    // xóa sinh viên theo id
    @DeleteMapping("")
    String delete(@RequestParam("id") int id){
        String message =studentService.delete(id);
        return message;
}


    @GetMapping("/{id}")
    StudentDTO findStudentById(@PathVariable int id) {
        return studentService.findStudentById(id);
    }
}

