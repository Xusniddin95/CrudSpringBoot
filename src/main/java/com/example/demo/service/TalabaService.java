package com.example.demo.service;


import com.example.demo.domain.Employee;
import com.example.demo.model.Talaba;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TalabaService {

    List<Talaba> getAllTalaba();

    void saveTalaba(Talaba talaba);

    Talaba getTalabaById(Long id);

    void deleteTalabaById(Long id);
}
