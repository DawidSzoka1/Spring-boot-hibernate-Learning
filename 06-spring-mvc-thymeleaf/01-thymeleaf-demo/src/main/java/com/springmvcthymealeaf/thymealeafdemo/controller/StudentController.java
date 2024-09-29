package com.springmvcthymealeaf.thymealeafdemo.controller;

import com.springmvcthymealeaf.thymealeafdemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @GetMapping("/student")
    public String student(Model model) {
        Student student = new Student("test", "test");
        model.addAttribute("student", student);
        return "student-form";
    }

    @PostMapping("/student")
    public String studentPost(@ModelAttribute("sadfasf") Student student) {

        return "student";
    }
}
