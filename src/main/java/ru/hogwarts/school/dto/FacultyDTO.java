package ru.hogwarts.school.dto;

import ru.hogwarts.school.model.Faculty;

public class FacultyDTO {
    private Long id;
    private String name;
    private String color;
    public static FacultyDTO fromFaculty( Faculty faculty ){
        FacultyDTO dto = new FacultyDTO();
        dto.setId(faculty.getId());
        dto.setName(faculty.getName());
        dto.setColor(faculty.getColor());
        return  dto;
    }
    public Faculty toFaculty() {
        Faculty faculty = new Faculty();
        faculty.setId(this.getId());
        faculty.setName(this.getName());
        faculty.setColor(this.getColor());
        return faculty;
    }


    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor( String color ) {
        this.color = color;
    }
}
