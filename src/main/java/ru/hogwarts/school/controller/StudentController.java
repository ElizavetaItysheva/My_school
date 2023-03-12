package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.dto.FacultyDTO;
import ru.hogwarts.school.dto.StudentDTO;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    public StudentController( StudentService studentService ) {
        this.studentService = studentService;
    }
    @GetMapping("{id}")
    public ResponseEntity<StudentDTO> getStudentInfo( @PathVariable Long id ){
        StudentDTO foundStudent = studentService.getStudentById(id);
        if(foundStudent == null){
            ResponseEntity.notFound().build();
        }
       return ResponseEntity.ok(foundStudent);
    }

    @PostMapping
    public StudentDTO addStudent( @RequestBody StudentDTO student){
        studentService.addStudent(student);

        return student;
    }
    @PutMapping
    public ResponseEntity<StudentDTO> editStudent(@RequestBody StudentDTO student){
        StudentDTO foundStudent = studentService.editStudent(student);
        if(foundStudent == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundStudent);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/age")
    public ResponseEntity<Collection<StudentDTO>> getStudentsByAge( @RequestParam Long age){
        Collection<StudentDTO> foundStudents = studentService.getStudentsByAge(age);
        if(foundStudents == null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundStudents);
    }
    @GetMapping("/betweenAge")
    public  ResponseEntity<Collection<StudentDTO>> getStudentsByAgeBetween(@RequestParam Long start, Long end){
        Collection<StudentDTO> foundStudents = studentService.getStudentsByAgeBetween(start, end);
        if(foundStudents == null){
            ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(foundStudents);
    }
    @GetMapping("{studentId}/faculty")
    public ResponseEntity<FacultyDTO> getFacultyOfStudentByStudentId(@PathVariable Long studentId){
        FacultyDTO foundFaculty = studentService.getFacultyOfStudentByStudentId(studentId);
        if(foundFaculty == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundFaculty);
    }
}
