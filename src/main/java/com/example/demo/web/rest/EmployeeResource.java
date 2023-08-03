package com.example.demo.web.rest;

import com.example.demo.domain.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeResource {

    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    create
    @PostMapping("/employes")
    public ResponseEntity create(@RequestBody Employee employee){
        Employee employee1 = employeeService.save(employee);
        return ResponseEntity.ok(employee1);
    }

//    read
    @GetMapping("/employes")
    public ResponseEntity getAll(){
        List<Employee> employeeList = employeeService.findAll();
        return ResponseEntity.ok(employeeList);
    }

    //    search
    @GetMapping("/employes/{name}")
    public ResponseEntity getAll(@PathVariable String name){
        List<Employee> employeeByName = employeeService.findByName(name);
        return ResponseEntity.ok(employeeByName);
    }

    @GetMapping("/employe/{name}")
    public ResponseEntity getByNameQuery(@PathVariable String name){
        List<Employee> employeeListQuery = employeeService.findByNameQuery(name);
        return ResponseEntity.ok(employeeListQuery);
    }
//    search
    @GetMapping("/employe/search")
    public ResponseEntity getByLike(@RequestParam String name){
        List<Employee> employeeLike = employeeService.findByLike(name);
        return ResponseEntity.ok(employeeLike);
    }

//Update
    @PutMapping("/employes")
    public ResponseEntity update(@RequestBody Employee employee){
        Employee employee1 = employeeService.save(employee);
        return ResponseEntity.ok(employee1);
    }

//    Delete
    @DeleteMapping("/employes/{Id}")
    public ResponseEntity delete(@PathVariable Long Id){
            employeeService.delete(Id);
            return ResponseEntity.ok("Qator o'chirildi!");
    }


}
