package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.*;

@Service
public class StudentService {
    private final HashMap<Long, Student> students = new HashMap<>();
    private Long lastId = 0L;
    public Student addStudent(Student student){
        student.setId(++lastId);
        students.put(lastId, student);
        return student;
    }
    public Student getStudentById(Long id){
        return  students.get(id);
    }
    public Student editStudent(Student student){
        students.put(student.getId(), student);
        return student;
    }
    public Student deleteStudent(Long id){
        return students.remove(id);
    }
    public Collection<Student> getStudentsByAge(int age){
        Collection<Student> temp = new ArrayList<>();
        for (Map.Entry<Long, Student> studentEntry: students.entrySet()) {
            if(studentEntry.getValue().getAge() == age){
                temp.add(studentEntry.getValue());
            }

        }
        return temp;
    }

}
