package com.abhishek.springjdbcquerytool.service;

import com.abhishek.springjdbcquerytool.dto.Student;
import com.abhishek.springjdbcquerytool.repository.StudentRepository;
import com.abhishek.springjdbcquerytool.repository.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudent() {
        return studentRepository.getAllStudent(new StudentMapper());
    }

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public void addAllStudents(List<Student> students) {
        studentRepository.addAllStudents(students);
    }

    public Student getStudentById(String id) {
        return studentRepository.getStudentById(id);
    }

    public String getStudentNameById(String id) {
        return studentRepository.getStudentNameById(id);
    }
}
