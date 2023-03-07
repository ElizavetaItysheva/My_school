package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<Faculty> getFacultyInfo( @PathVariable Long id ){
        Faculty foundFaculty = houseService.getFacultyById(id);
        if(foundFaculty == null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundFaculty);
    }

    @PostMapping
    public Faculty addFaculty(@RequestBody Faculty faculty){
        return  houseService.addFaculty(faculty);
    }
    @PutMapping
    public ResponseEntity<Faculty> editFaculty( @RequestBody Faculty faculty){
        Faculty foundFaculty = houseService.editFaculty(faculty);
        if(foundFaculty == null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundFaculty);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Faculty> deletefaculty(@PathVariable Long id){
        Faculty foundFaculty = houseService.getFacultyById(id);
        if(foundFaculty == null){
            ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(foundFaculty);
    }
    @GetMapping
    public ResponseEntity<Collection<Faculty>> getFacultyByColor( @RequestParam String color){
        Collection<Faculty> foundFaculties = houseService.getFacultyByColor(color);
        if(foundFaculties == null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundFaculties);
    }
}
