package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.dto.FacultyDTO;
import ru.hogwarts.school.dto.StudentDTO;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.HouseService;

import java.util.Collection;

@RestController
@RequestMapping("faculty")
public class HouseController {

    private final HouseService houseService;

    public HouseController( HouseService houseService ) {
        this.houseService = houseService;
    }

    @GetMapping("{id}")
    public ResponseEntity<FacultyDTO> getFacultyInfo( @PathVariable Long id ){
        FacultyDTO foundFaculty = houseService.getFacultyById(id);
        if(foundFaculty == null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundFaculty);
    }

    @PostMapping
    public FacultyDTO addFaculty( @RequestBody FacultyDTO faculty){
        return  houseService.addFaculty(faculty);
    }
    @PutMapping
    public ResponseEntity<FacultyDTO> editFaculty( @RequestBody FacultyDTO faculty){
        FacultyDTO foundFaculty = houseService.editFaculty(faculty);
        if(foundFaculty == null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundFaculty);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Faculty> deleteFaculty(@PathVariable Long id){
        houseService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/color")
    public ResponseEntity<Collection<FacultyDTO>> getFacultyByColor( @RequestParam String color){
        Collection<FacultyDTO> foundFaculties = houseService.getFacultyByColor(color);
        if(foundFaculties == null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundFaculties);
    }
    @GetMapping("/faculty")
    public ResponseEntity<FacultyDTO> getFacultyByName(@RequestParam String name){
        FacultyDTO foundFaculty = houseService.getFacultyByName(name);
        if(foundFaculty == null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundFaculty);
    }
    @GetMapping("/facultyStudents")
    public ResponseEntity<Collection<StudentDTO>> getStudentsByIdOfFaculty(@RequestParam Long facultyId){
        Collection<StudentDTO> founded = houseService.getStudentsByIdOfFaculty(facultyId);
        if(founded == null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(founded);
    }
}
