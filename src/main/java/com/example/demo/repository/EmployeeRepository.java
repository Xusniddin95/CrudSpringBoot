package com.example.demo.repository;

import com.example.demo.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByName(String name);

    @Query("Select e from Employee e WHERE e.name = :name")
    List<Employee> findByNameQuery(@Param("name") String name);

//    search
    @Query("Select e from Employee  e WHERE UPPER(e.name) like upper(concat('%',:name,'%') ) ")
    List<Employee> findByLike(@Param("name") String name);
}
