package com.example.demo.web.rest;

import com.example.demo.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResource {


//    Get method

////    birinchi usul
//    @GetMapping("/students")
//    public String hello(){
//        return "Hello World!!!";
//    }
//
////    ikkinchi usul
//    @RequestMapping(value = "/talabalar", method = RequestMethod.GET)
//    public String salom(){
//        return "Salom Dunyo!!!";
//    }


    @GetMapping("/students/all")
    public ResponseEntity getAll(){
        Student student = new Student(1l,"Aziz","Azimov","2-kurs");
        Student student2 = new Student(2l,"Nematjon","Yusubjonov","3-kurs");
        Student student3 = new Student(3l,"Murodjon","Nematullayev","4-kurs");

        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student2);
        students.add(student3);

        return ResponseEntity.ok(students);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Student student = new Student(id,"Xusniddin","Erkinov","2-kurs");
        return ResponseEntity.ok(student);
    }


    @GetMapping("/students")
    public ResponseEntity getOne(@RequestParam Long id,
                                 @RequestParam String name,
                                 @RequestParam String lastName,
                                 @RequestParam String course){

        Student student = new Student(id, name, lastName, course);

        return ResponseEntity.ok(student);

    }



//    Post Method

    @PostMapping("students")
    public ResponseEntity create(@RequestBody Student student){
        return ResponseEntity.ok(student);
    }



//    Put method

    @PutMapping("/students/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody Student studentNew){
        Student student = new Student(1l,"Xusniddin","Erkinov","2-kurs");

        student.setId(id);
        student.setName(studentNew.getName());
        student.setLastName(studentNew.getLastName());
        student.setCourse(studentNew.getCourse());

        return ResponseEntity.ok(student);

    }



//    Delete Method
    @DeleteMapping("/students/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok("Malumotlar o'chirildi.");
    }
}
