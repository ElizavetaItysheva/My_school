package ru.hogwarts.school.service;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.dto.FacultyDTO;
import ru.hogwarts.school.dto.StudentDTO;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.FacultyRepository;

import java.util.ArrayList;
import java.util.Collection;
@Service
public class HouseService {

    private final FacultyRepository facultyRepository;

    public HouseService( FacultyRepository facultyRepository ) {
        this.facultyRepository = facultyRepository;
    }

    public FacultyDTO addFaculty( FacultyDTO faculty ) {
        facultyRepository.save(faculty.toFaculty());
        return faculty;
    }

    public FacultyDTO getFacultyById( Long id ) {
        Faculty faculty1 = facultyRepository.findById(id).get();

        return FacultyDTO.fromFaculty(faculty1);
    }

    public FacultyDTO editFaculty( FacultyDTO faculty ) {
        facultyRepository.save(faculty.toFaculty());

        return faculty;
    }

    public void deleteFaculty( Long id ) {
        facultyRepository.deleteById(id);
    }
    public Collection<FacultyDTO> getFacultyByColor( String color){
        Collection<Faculty> founded = facultyRepository.findByColor(color);
        Collection<FacultyDTO> dto = new ArrayList<>();
        for(Faculty faculty : founded){
           FacultyDTO facultyDTO = FacultyDTO.fromFaculty(faculty);
           dto.add(facultyDTO);
        }
        return dto;
    }
    public FacultyDTO getFacultyByName(String name){
        Faculty founded = facultyRepository.findByNameIgnoreCase(name);

        return FacultyDTO.fromFaculty(founded);
    }
    public Collection<StudentDTO> getStudentsByIdOfFaculty(Long facultyId){
        Faculty founded = facultyRepository.findById(facultyId).get();
        Collection<Student> students = founded.getStudents();
        Collection<StudentDTO> studentDTOs = new ArrayList<>();
        for(Student student : students){
            StudentDTO studentDTO = StudentDTO.fromStudent(student);
            studentDTOs.add(studentDTO);
        }
        return studentDTOs;
    }
}
