package com.example.baseproject.service;

import com.example.baseproject.dto.StudentDTO;
import com.example.baseproject.repository.StudentRepository;
import com.example.baseproject.service.impl.StudentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements StudentImpl {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<StudentDTO> findAll() {
        List<StudentDTO> resp = new ArrayList<>();
        var studentList = studentRepository.findAll();

        studentList.forEach(s -> {
            var student = StudentDTO.builder()
                    .name(s.getName())
                    .build();

            resp.add(student);
        });
        return resp;
    }
}
