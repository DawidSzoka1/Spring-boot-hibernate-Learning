package com.restcrud.restcontroler.rest;

import com.restcrud.restcontroler.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    //load students only once with is better than every time someone visits this page
    @PostConstruct
    public void loadStudents() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("first", "last"));
        theStudents.add(new Student("first", "mario"));
        theStudents.add(new Student("tom", "last"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {

        //spring will use jackson to convert it to json using getters from student class
        return theStudents;
    }

    @GetMapping("/student/name/{name}")
    public List<Student> getStudentsByName(
            // type ?firstName=value after path
//            @RequestParam("firstName") String name
            @PathVariable String name
    ) {
        List<Student> namein = new ArrayList<>();
        for(Student student : theStudents) {
            if(student.getFirstName().equals(name)) {
                namein.add(student);
            }
        }

        return namein;
    }

    @GetMapping("student/{id}")
    public Student getStudent(@PathVariable int id) {
        if(id >= theStudents.size() || id < 0) {
            throw new StudentNotFoundException("Student with that id doesnt exists " + id);
        }
        return theStudents.get(id);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exp) {
        StudentErrorResponse response = new StudentErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exp.getMessage(),
                System.currentTimeMillis()
        );


        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}



