package com.restcrud.restcontroler.rest;

import com.restcrud.restcontroler.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<Student>();

        students.add(new Student("first", "last"));
        students.add(new Student("Mario", "Ball"));
        students.add(new Student("first", "leo"));
        return students;
    }
}
