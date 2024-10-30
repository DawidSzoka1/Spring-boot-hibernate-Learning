package com.example.remider;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private StudentDaoImpl studentDao;

    @Autowired
    public StudentController(StudentDaoImpl studentDao) {
        this.studentDao = studentDao;
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("students", studentDao.findAll());
        return "index";
    }

    @GetMapping("/add/student")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "student-add";
    }

    @PostMapping("/add/student")
    public String addStudent(@Valid Student s, BindingResult result) {
        if (result.hasErrors()) {
            return "student-add";
        }
        studentDao.save(s);
        return "redirect:/index";
    }

    @PostMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id) {
        Student s = studentDao.findById(id);
        if (s == null) {
            return "redirect:/index";
        }
        studentDao.delete(s);
        return "redirect:/index";
    }

    @GetMapping("/student/{id}")
    public String getStudent(@PathVariable int id, Model model) {
        Student s = studentDao.findById(id);
        if(s == null) {
            return "redirect:/index";
        }
        model.addAttribute("student", s);
        return "student-view";
    }

}
