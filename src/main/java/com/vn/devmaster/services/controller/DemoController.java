package com.vn.devmaster.services.controller;

import com.vn.devmaster.services.dto.StudentDTO;
import com.vn.devmaster.services.entites.Student;
import com.vn.devmaster.services.projection.IStudentPoint;
import com.vn.devmaster.services.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DemoController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/index")
    public String showIndex(Model model){
        model.addAttribute("name", "Hiếu");
        return "index";
    }
    @GetMapping("/show_student")
    public String showStudnet(Model model){
        StudentDTO student = new StudentDTO();
        student.setName("Hiếu");
        student.setAddress("Hà Nội");
     model.addAttribute("student", student);
     return "index";
    }
    @GetMapping("/find_by_address")
    public String FindByAddress (@RequestParam("address") String address, Model model){
       List<StudentDTO> studentDTOS = studentService.findByAddress(address);
       model.addAttribute("studentDTOS", studentDTOS);
       return "index";
    }

    @GetMapping("/showAll")
    public String FindAll (Model model){
        List<Student> student = studentService.findAll();
        model.addAttribute("studentAll", student);
        return "index";
    }


    //chuyển đến trang thêm sinh viên
    @GetMapping("/add-student")
    public String AddStudent(Model model){
        model.addAttribute("student" ,new Student());
        return "Add-student";
    }
    // thêm sinh viên
    @PostMapping("/addstudent")
    public String addstudent(@ModelAttribute("student") StudentDTO student) {
        studentService.save(student);
        return "redirect:/showAll";
    }


    // chuyển đến trang sửa sinh viên
    @GetMapping("/update-student/{id}")
    public String UpdateStudent(Model model,
                                    @PathVariable("id") int id) {
        model.addAttribute("id", id);
        Student studentDTO = studentService.findById(id);
        model.addAttribute("studentDTO", studentDTO);
        return "Update-student";
    }

    // sửa sinh viên
    @PostMapping("/updatestudent/{id}")
    public String updateStudent(@PathVariable("id") int id,
                                @ModelAttribute("studentDTO") StudentDTO studentDTO) {
        studentService.update(id, studentDTO);
    return "redirect:/showAll";

}
    // chuyển đến trang xoá sinh viên
    @GetMapping("/delete-student")
    public String Deletestudent(Model model){
        return "Delete-student";
    }


    // Xóa sinh viên theo ID
    @PostMapping("deletestudent")
    public String deleteStudent(@RequestParam("id") int id) {
        studentService.delete(id);
        return "redirect:/showAll";
    }

}
