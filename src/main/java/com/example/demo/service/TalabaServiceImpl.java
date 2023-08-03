package com.example.demo.service;

import com.example.demo.model.Talaba;
import com.example.demo.repository.TalabaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TalabaServiceImpl implements TalabaService {

    @Autowired
    private TalabaRepository talabaRepository;

//    read
    @Override
    public List<Talaba> getAllTalaba() {
        return talabaRepository.findAll();
    }

//    create
    @Override
    public void saveTalaba(Talaba talaba) {
        this.talabaRepository.save(talaba);
    }

//    update
    @Override
    public Talaba getTalabaById(Long id) {
        Optional<Talaba> optional = talabaRepository.findById(id);
        Talaba talaba = null;
        if (optional.isPresent()){
            talaba = optional.get();
        }else{
            throw new RuntimeException(id + " da talaba topilmadi!");
        }
        return talaba;
    }

//    delete
    @Override
    public void deleteTalabaById(Long id) {
        this.talabaRepository.deleteById(id);
    }


}
