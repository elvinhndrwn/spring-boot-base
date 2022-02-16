package com.example.baseproject.controller;

import com.example.baseproject.dto.StudentDTO;
import com.example.baseproject.service.StudentService;
import com.example.baseproject.service.impl.StudentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public List<StudentDTO> all(){
        return studentService.findAll();
    }
}
