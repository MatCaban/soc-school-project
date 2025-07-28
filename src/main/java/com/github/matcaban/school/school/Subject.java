package com.github.matcaban.school.school;

import com.github.matcaban.school.members.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private final String name;
    private final Teacher teacher;
    private final List<Grade> grades;

    public Subject(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
        this.grades = new ArrayList<>();
    }

    public void addGrade(double grade) {
        this.grades.add(new Grade(grade));
    }

    public String getName() {
        return name;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public double getAverageGrade() {
        return this.grades.stream()
                .mapToDouble(Grade::getGrade)
                .average()
                .orElse(0);
    }
}
