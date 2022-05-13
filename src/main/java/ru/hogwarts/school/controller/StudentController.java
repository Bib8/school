package ru.hogwarts.school.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public ResponseEntity getStudentInfo(@PathVariable Long id){
        Student student = studentService.findStudentById(id);
        if(student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public ResponseEntity addStudent(@RequestBody Student student){
        Student addedStudent = studentService.addStudent(student);
        return ResponseEntity.ok(addedStudent);
    }

    @PutMapping()
    public ResponseEntity updateUser(@RequestBody Student student) {
        Student updatedStudent = studentService.editStudent(student);
        if (updatedStudent == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("id")
    public ResponseEntity deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<Collection<Student>> getAllStudent (){
        return ResponseEntity.ok(studentService.GetAllStudent());
    }

    @GetMapping("age")
    public ResponseEntity<Collection<Student>> findByAge(@PathVariable Integer age){
        return ResponseEntity.ok(studentService.findByAge(age));
    }

    @GetMapping("/filterByAgeBetween")
    public ResponseEntity<Collection<Student>> findStudentByAgeBetween(@RequestParam Integer minAge, Integer maxAge){
        return ResponseEntity.ok(studentService.findStudentByAgeBetween(minAge, maxAge));
    }

    @GetMapping("/filterFindAllByNameOrderByName")
    public ResponseEntity<Collection<Student>> findAllByNameOrderByName(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/filterFindStudentByNameContains")
    public ResponseEntity<Object> findAllByNameContainsOrderByNameIgnoreCase(@RequestParam String str){
        return ResponseEntity.ok(studentService.findAllByNameContainsOrderByNameIgnoreCase(str));
    }

    @GetMapping("/filterFindAllByAgeBefore")
    public ResponseEntity<Collection<Student>> findAllByAgeBefore(@RequestParam Integer age){
        return ResponseEntity.ok(studentService.findAllByAgeBefore(age));
    }
    @GetMapping("/filterFindAllByAgeOrderByAge")
    public ResponseEntity<Collection<Student>> findAllByAgeOrderByAge(){
        return ResponseEntity.ok(studentService.findAllByAgeOrderByAge());
    }











}
