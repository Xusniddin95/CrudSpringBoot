package com.example.demo.service;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

//    save
    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

//    getAll
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

//    findByName
    public List<Employee> findByName(String name){
        return employeeRepository.findByName(name);
    }

//    findByName for Query
    public List<Employee> findByNameQuery(String name){
        return employeeRepository.findByNameQuery(name);
    }

//    search by name
    public List<Employee> findByLike(String name){
        return employeeRepository.findByLike(name);
    }

//    delete
    public void delete(Long Id){
        employeeRepository.deleteById(Id);
    }


}
