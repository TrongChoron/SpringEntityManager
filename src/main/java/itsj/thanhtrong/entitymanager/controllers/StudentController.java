package itsj.thanhtrong.entitymanager.controllers;

import itsj.thanhtrong.entitymanager.models.Student;
import itsj.thanhtrong.entitymanager.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Mon, 7/4/2022
 * Time     : 15:18
 * Filename : StudentController
 */
@Controller
@RequestMapping("api/v1")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @PostMapping("/student")
    public ResponseEntity<Student> addNewStudent(@RequestBody Student student){
        return ResponseEntity.ok(studentService.addNewStudent(student));
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id,@RequestBody Student student){
        return ResponseEntity.ok(studentService.updateStudent(id,student));
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
    }
}
