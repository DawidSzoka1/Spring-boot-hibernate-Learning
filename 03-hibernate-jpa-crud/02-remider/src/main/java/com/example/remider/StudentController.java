package com.example.remider;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @GetMapping("")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/add/student")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "student-add";
    }

    @PostMapping("/add/student")
    public String addStudent(@Valid Student s, BindingResult result) {
        return "student-post";
    }

}
