package ru.hogwarts.school.Service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.Model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

@Service
public class StudentService {

    private final HashMap<Long, Student> students = new HashMap<>();
    private long lastId = 0;

    public Student addStudent(Student student){
        student.setId(++lastId);
        students.put(lastId, student);
        return student;
    }

    public Student findStudentById(long id){
        return students.get(id);
    }

    public Student editStudent(Student student){
        students.put(student.getId(), student);
        return student;
    }

    public Student deleteStudent(long id){
        return students.remove(id);
    }

    public HashMap<Long, Student> filterStudent(Integer age){
        return new HashMap<>(students.entrySet().
                stream().
                filter(x->age.equals(x.getValue().getAge())).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }

}
