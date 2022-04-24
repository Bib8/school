package ru.hogwarts.school.Controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.Model.Faculty;
import ru.hogwarts.school.Model.Student;
import ru.hogwarts.school.Service.FacultyService;

import java.util.Collection;
import java.util.HashMap;

@RestController
@RequestMapping("faculty")
public class FacultyController {

    private final FacultyService facultyService;


    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("{id}")
    public ResponseEntity getFacultyInfo(@PathVariable Long id){
        Faculty faculty = facultyService.findFacultyById(id);
        if(faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PostMapping
    public ResponseEntity addFaculty(@io.swagger.v3.oas.annotations.parameters.RequestBody Faculty faculty){
        Faculty addedFaculty = facultyService.addFaculty(faculty);
        return ResponseEntity.ok(addedFaculty);
    }

    @PutMapping()
    public ResponseEntity updateFaculty(@RequestBody Faculty faculty) {
        Faculty updatedFaculty = facultyService.editFaculty(faculty);
        if (updatedFaculty == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(updatedFaculty);
    }

    @DeleteMapping("id")
    public ResponseEntity deleteFaculty(@PathVariable Long id){
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("color")
    public ResponseEntity<Collection<Faculty>> filterFacultyByColor(@PathVariable String color){
        return ResponseEntity.ok(facultyService.findByColor(color));
    }

    @GetMapping()
    public ResponseEntity<Collection<Faculty>> getAllStudent (){
        return ResponseEntity.ok(facultyService.GetAllFaculty());
    }
}
