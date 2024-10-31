package com.example.databaseproject.service;


import com.example.databaseproject.dao.StudentRepository;
import com.example.databaseproject.entity.Student;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findById(student.getId());
        if (studentOptional.isPresent()) {
            studentRepository.save(student);
        }else{
            throw new EntityNotFoundException("Student not found");
        }
    }

    @Override
    public void deleteStudent(int id) {
        Optional<Student> s = studentRepository.findById(id);
        if(s.isPresent()) {
            studentRepository.delete(s.get());
        }else{
            throw new EntityNotFoundException("Student with id " + id + " not found");
        }
    }

    @Override
    public Optional<Student> getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }
}
