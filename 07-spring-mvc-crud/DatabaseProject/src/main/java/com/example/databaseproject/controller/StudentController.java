package com.example.databaseproject.controller;

import com.example.databaseproject.entity.Student;
import com.example.databaseproject.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "list-students";
    }

    @GetMapping("/formAdd")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "form-student";
    }

    @PostMapping("/save")
    public String postForm(@Valid Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form-student";
        }
        studentService.saveStudent(student);
        return "redirect:/student/list";
    }
}
