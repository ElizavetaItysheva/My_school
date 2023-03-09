package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repositories.FacultyRepository;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class HouseService {

    private final FacultyRepository facultyRepository;

    public HouseService( FacultyRepository facultyRepository ) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty addFaculty( Faculty faculty ) {
        return facultyRepository.save(faculty);
    }

    public Faculty getFacultyById( Long id ) {
        return facultyRepository.findById(id).get();
    }

    public Faculty editFaculty( Faculty faculty ) {
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty( Long id ) {
        facultyRepository.deleteById(id);
    }
    public Collection<Faculty> getFacultyByColor( String color){
        return facultyRepository.findByColor(color);
    }
}
