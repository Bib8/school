package ru.hogwarts.school.model;

import nonapi.io.github.classgraph.json.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Objects;
@Entity
public class Student {
    @javax.persistence.Id
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int age;

    @OneToOne(mappedBy = "name")
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    public Faculty getFaculty() {
        return faculty;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getAge() == student.getAge() && getId().equals(student.getId()) && getName().equals(student.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge());
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


}
