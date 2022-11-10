package net.demo.springboot.controller;


import net.demo.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {


    @GetMapping
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1, "francis", "nodado");

//        return new ResponseEntity<>(student, HttpStatus.OK);
//        return ResponseEntity.ok(student);
        return ResponseEntity.ok().header("custom-header", "franz").body(student);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Student>> getStudentList() {
        List<Student> studentList = new ArrayList<>();
        Student student = new Student(1, "francis", "nodado");

        studentList.add(student);


//        return studentList;
        return ResponseEntity.ok(studentList);
    }

    // {id} - URI template variable
    // localhost:8080/student/1
    @GetMapping("/{id}")
    public Student getstudentPathVariable(@PathVariable("id") int id) {
        return new Student(id, "dahryl", "nodado");
    }

    @GetMapping("/{id}/{first-name}/{last-name}")
    public Student getstudentPathVariable2(@PathVariable("id") int id,
                                           @PathVariable("first-name") String firstName,
                                           @PathVariable("last-name") String lastName) {
        return new Student(id, "welli ann", "sy");
    }

    // ?id= query parameter
    // localhost:8080/student?id=1
    @GetMapping("/query")
    public Student getStudentRequestVariable(@RequestParam int id) {
        return new Student(id, "welli ann", "sy");
    }

    // localhost:8080/student?id=1&firstName=francis&lastName=nodado
    @GetMapping("/query/multiple")
    public Student getStudentRequestVariable2(@RequestParam int id,
                                              @RequestParam String firstName,
                                              @RequestParam String lastName) {
        return new Student(id, "dahryl", "salmeron");
    }

    @PostMapping
    public String saveStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return "student is saved...";
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int id) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());


        return student;
    }

    @DeleteMapping("/{id}/update")
    public String deleteStudent(@PathVariable("id") int id) {
        return "Student deleted";
    }

}
