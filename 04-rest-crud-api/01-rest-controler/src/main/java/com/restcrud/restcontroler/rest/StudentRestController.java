package com.restcrud.restcontroler.rest;

import com.restcrud.restcontroler.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    public List<Student> getStudentsList(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("first", "last"));
        students.add(new Student("Mario", "Ball"));
        students.add(new Student("first", "leo"));
        return students;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {

        //spring will use jackson to convert it to json using getters from student class
        return getStudentsList();
    }

    @GetMapping("/student/name/{name}")
    public List<Student> getStudentsByName(
            // type ?firstName=value after path
//            @RequestParam("firstName") String name
            @PathVariable String name
    ) {
        List<Student> students = getStudentsList();
        List<Student> namein = new ArrayList<>();
        for(Student student : students) {
            if(student.getFirstName().equals(name)) {
                namein.add(student);
            }
        }

        return namein;
    }

    @GetMapping("student/{id}")
    public Student getStudent(@PathVariable int id) {
        List<Student> students = getStudentsList();
        if(id > students.size()) {
            return null;
        }
        return students.get(id);
    }
}
