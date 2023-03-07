package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class HouseService {
    private final HashMap<Long, Faculty> faculties = new HashMap<>();
    private Long lastId;

    public Faculty addFaculty( Faculty faculty ) {
        faculty.setId(++lastId);
        faculties.put(lastId, faculty);
        return faculty;
    }

    public Faculty getFacultyById( Long id ) {
        return faculties.get(id);
    }

    public Faculty editFaculty( Faculty faculty ) {
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty deleteFaculty( Long id ) {
        return faculties.remove(id);
    }
    public Collection<Faculty> getFacultyByColor( String color){
        Collection<Faculty> temp = new ArrayList<>();
        for (Map.Entry<Long, Faculty> facultyEntry: faculties.entrySet()) {
            if(facultyEntry.getValue().getColor().equals(color)){
                temp.add(facultyEntry.getValue());
            }
        }
        return temp;
    }
}
