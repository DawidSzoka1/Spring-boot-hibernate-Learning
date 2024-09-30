package com.springmvcthymealeaf.thymealeafdemo.controller;

import com.springmvcthymealeaf.thymealeafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;


@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${language}")
    private List<String> language;

    @Value("${system}")
    private List<String> system;

    @GetMapping("/student")
    public String student(Model model) {
        Student student = new Student("test",
                "test",
                "India",
                "Python",
                Arrays.asList("macOS", "Linux")
        );

        model.addAttribute("student", student);

        model.addAttribute("countries", countries);

        model.addAttribute("language", language);

        model.addAttribute("system", system);

        return "student-form";
    }

    @PostMapping("/student")
    public String studentPost(@ModelAttribute("sadfasf") Student student) {

        return "student";
    }
}
