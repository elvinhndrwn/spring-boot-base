package com.example.baseproject.controller;

import com.example.baseproject.constant.BaseConstant;
import com.example.baseproject.dto.StudentDTO;
import com.example.baseproject.service.StudentService;
import com.example.baseproject.service.impl.StudentImpl;
import com.example.baseproject.service.kafka.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    Publisher publisher;

    @GetMapping("/all")
    public List<StudentDTO> all(){
        return studentService.findAll();
    }

    @GetMapping("/kafka")
    public String test(){

        publisher.publish(StudentDTO.builder().name("Intan syg").build());
        return "Kafka send";
    }
}
