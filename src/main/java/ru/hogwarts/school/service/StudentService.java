package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.StudentRepository;
import ru.hogwarts.school.model.Student;
import java.util.Collection;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public Student findStudentById(long id){
        return studentRepository.findById(id).get();
    }

    public Student editStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteStudent(long id){
        studentRepository.deleteById(id);
    }

    public Collection<Student> GetAllStudent(){
        return studentRepository.findAll();
    }

    public List<Student> findByAge(Integer age){
        return studentRepository.findByAge(age);
    }

    public Collection<Student> findStudentByAgeBetween(Integer minAge, Integer maxAge){
        return studentRepository.findStudentByAgeBetween(minAge, maxAge);
    }

    public Collection<Student> findAll(){
        return studentRepository.findStudentByNameExistsIgnoreCase();
    }
    public Collection<Student> findStudentByNameContains(String str){
        return studentRepository.findStudentByNameContainsIgnoreCase(str);
    }

    public Collection<Student> findAllByAgeBefore(Integer age){
        return studentRepository.findAllByAgeBefore(age);
    }

    public Collection<Student> findAllByAgeOrderByAge(){
        return studentRepository.findStudentByAgeExists();
    }


    public Object findAllByNameContainsOrderByNameIgnoreCase(String str) {
        return studentRepository.findAllByNameContainsOrderByName(str);
    }
}
