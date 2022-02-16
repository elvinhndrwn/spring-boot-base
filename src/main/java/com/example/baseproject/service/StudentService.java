package com.example.baseproject.service;

import com.example.baseproject.dto.StudentDTO;
import com.example.baseproject.repository.StudentRepository;
import com.example.baseproject.service.impl.StudentImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.example.baseproject.constant.BaseConstant.STUDENT_CACHE;

@Service
@Slf4j
public class StudentService implements StudentImpl {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    Producer producer;

    @Autowired
    private HashOperations<String, Object, Object> redisOps;

    @Override
    public List<StudentDTO> findAll() {
        List<StudentDTO> resp = new ArrayList<>();
        Map<Object, Object> studentMap =redisOps.entries(STUDENT_CACHE);

        if (studentMap.isEmpty()){
            log.info("Get data from database");
            var studentList = studentRepository.findAll();

            List<StudentDTO> finalResp = resp;
            studentList.forEach(s -> {
                var student = StudentDTO.builder()
                        .name(s.getName())
                        .build();

                redisOps.put(STUDENT_CACHE, student.getName(), student);
                finalResp.add(student);
            });
        }else{
            log.info("Return data from redis cache");
            resp = new ArrayList(studentMap.values());
        }
        producer.send(resp);
        return resp;

    }
}
