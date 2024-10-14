package com.kapil.springbootjpa2.service;

import com.kapil.springbootjpa2.entity.Student;

import java.util.List;

public interface StudentService {
    Student getStudentById(Long id);
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student updateStudent(Student student);
    void deleteStudent(Long id);
    Student getStudentByName(String name);
    Student getStudentByEmail(String email);
    Student getStudentByPhone(String phone);
    void setCountryByState(String state, String country);
}
