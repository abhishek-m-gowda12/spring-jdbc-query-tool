package com.abhishek.springjdbcquerytool.controller;

import com.abhishek.springjdbcquerytool.dto.Student;
import com.abhishek.springjdbcquerytool.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getAllStudent() {

        List<Student> students = service.getAllStudent();

        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> getStudentById(@PathVariable("id") String id) {

        Student student = service.getStudentById(id);

        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @GetMapping(value = "/name/{id}")
    public ResponseEntity<String> getStudentNameById(@PathVariable("id") String id) {

        String studentName = service.getStudentNameById(id);

        return ResponseEntity.status(HttpStatus.OK).body(studentName);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addStudent(@RequestBody Student student) {

        service.addStudent(student);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping(value = "/all", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addAllStudents(@RequestBody List<Student> students) {

        service.addAllStudents(students);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
