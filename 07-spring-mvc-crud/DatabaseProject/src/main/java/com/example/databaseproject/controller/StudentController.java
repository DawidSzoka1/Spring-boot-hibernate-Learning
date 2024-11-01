package com.example.databaseproject.controller;

import com.example.databaseproject.entity.Student;
import com.example.databaseproject.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        model.addAttribute("students", studentService.findAllByOrderByLastNameAsc());
        return "students/list-students";
    }

    @GetMapping("/formAdd")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "students/form-student";
    }

    @PostMapping("/save")
    public String postForm(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "students/form-student";
        }
        studentService.saveStudent(student);
        return "redirect:/student/list";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) throws Exception {
        Optional<Student> student = studentService.getStudentById(id);
        if(student.isPresent()) {
            studentService.deleteStudent(id);
            return "redirect:/student/list";
        }else{
            throw new Exception();
        }
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        if(studentService.getStudentById(id).isEmpty()) {
            return "redirect:/student/list";
        }
        model.addAttribute("student", studentService.getStudentById(id));
        return "students/form-student";
    }

    @PostMapping("/update/{id}")
    public String postUpdateForm(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/student/update/" + student.getId();
        }
        studentService.updateStudent(student);
        return "redirect:/student/list";
    }
}
