package com.example.demo.repository;

import com.example.demo.model.Talaba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TalabaRepository extends JpaRepository<Talaba, Long> {


}

