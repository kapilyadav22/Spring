package com.kapil.springbootjpa2.controllers;

import com.kapil.springbootjpa2.entity.Student;
import com.kapil.springbootjpa2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

//    @GetMapping("")
//    Student getStudentById(@RequestParam long id) {
//        return studentService.getStudentById(id);
//    }

    @GetMapping
    List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/name/{name}")
    Student getStudentByName(@PathVariable String name) {
        return studentService.getStudentByName(name);
    }

//    @GetMapping("/{email}")
//    Student getStudentByEmail(@PathVariable String email) {
//        return studentService.getStudentByEmail(email);
//    }

//    @GetMapping("/{phone}")
//    Student getStudentByPhone(@PathVariable String phone) {
//        return studentService.getStudentByPhone(phone);
//    }

    @PostMapping
    Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PostMapping("/update")
    Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/{id}")
    void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @PostMapping("/{state}")
    void updateStudent(@PathVariable String state) {
        String Country = "";
        if(state.equalsIgnoreCase("delhi")) {
            Country = "India";
        } else if(state.equalsIgnoreCase("Lahore")) {
            Country = "Pakistan";
        } else if(state.equalsIgnoreCase("Alberta")) {
            Country = "Canada";
        }
       studentService.setCountryByState(state,Country);
    }


}
