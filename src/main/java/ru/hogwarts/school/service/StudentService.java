package ru.hogwarts.school.service;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.dto.FacultyDTO;
import ru.hogwarts.school.dto.StudentDTO;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.FacultyRepository;
import ru.hogwarts.school.repositories.StudentRepository;
import java.util.*;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final FacultyRepository facultyRepository;

    public StudentService( StudentRepository studentRepository, FacultyRepository facultyRepository ) {
        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
    }

    public StudentDTO addStudent(StudentDTO student){
        Student student1 = student.toStudent();
        student1.setFaculty(facultyRepository.findById(student.getFacultyId()).get());
        StudentDTO studentDTO = StudentDTO.fromStudent(student1);
        studentRepository.save(student1);

        return studentDTO;
    }
    public StudentDTO getStudentById(Long id){
        Student founded = studentRepository.findById(id).get();

        return  StudentDTO.fromStudent(founded);
    }
    public StudentDTO editStudent(StudentDTO student){
        studentRepository.save(student.toStudent());

        return student;
    }
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
    public Collection<StudentDTO> getStudentsByAge(Long age){
        Collection<Student> founded = studentRepository.findByAge(age);
        Collection<StudentDTO> dto = new ArrayList<>();
        for (Student student : founded) {
            StudentDTO studentDTO = StudentDTO.fromStudent(student);
            dto.add(studentDTO);
        }
        return dto;
    }
    public Collection<StudentDTO> getStudentsByAgeBetween(Long start, Long end){
        Collection<Student> founded = studentRepository.findByAgeBetween(start, end);
        Collection<StudentDTO> dto = new ArrayList<>();
        for (Student student : founded) {
            StudentDTO studentDTO = StudentDTO.fromStudent(student);
            dto.add(studentDTO);
        }
        return dto;
    }
    public FacultyDTO getFacultyOfStudentByStudentId(Long studentId){
//        Student student = studentRepository.findById(studentId).get();
//        return FacultyDTO.fromFaculty(student.getFaculty());
        Faculty faculty = facultyRepository.findById(getStudentById(studentId).getFacultyId()).get();
        return FacultyDTO.fromFaculty(faculty);
    }

}
