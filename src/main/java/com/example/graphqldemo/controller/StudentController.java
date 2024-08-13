package com.example.graphqldemo.controller;

import com.example.graphqldemo.model.Student;
import com.example.graphqldemo.service.StudentService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @QueryMapping
    public Optional<Student> studentById(@Argument Long id) {
        return studentService.getStudentById(id);
    }

    @QueryMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @MutationMapping
    public Student addStudent(@Argument Long id, @Argument String name, @Argument String course, @Argument int roll) {
        Student student = new Student(id, name, course, roll);
        return studentService.saveStudent(student);
    }
}
