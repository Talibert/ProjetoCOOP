package com.projetocoop.dto.response;

import com.projetocoop.types.CoursesType;
import com.projetocoop.types.Teacher;

public class TeacherResponseDTO implements Comparable<TeacherResponseDTO>{

    private String name;

    private String description;

    public TeacherResponseDTO() {
    }

    public TeacherResponseDTO(Teacher teacher){
        this.name = teacher.name();
        this.description = teacher.getDescription();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int compareTo(TeacherResponseDTO other) {
        return this.name.compareTo(other.name);
    }
}
