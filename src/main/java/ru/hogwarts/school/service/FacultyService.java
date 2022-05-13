package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.FacultyRepository;
import ru.hogwarts.school.model.Faculty;
import java.util.Collection;

@Service

public class FacultyService {

    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }


    public Faculty addFaculty(Faculty faculty){
        return facultyRepository.save(faculty);
    }

    public Faculty findFacultyById(long id){
        return facultyRepository.findById(id).get();
    }

    public Faculty editFaculty(Faculty faculty){
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id){
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> findByColor(String color){
        return facultyRepository.findByColor(color);
    }

    public Collection<Faculty> GetAllFaculty(){
        return facultyRepository.findAll();
    }
}
