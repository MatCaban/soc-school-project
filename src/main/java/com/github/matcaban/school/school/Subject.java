package com.github.matcaban.school.school;

import com.github.matcaban.school.members.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Subject {
    private String name;
    private Teacher teacher;
    private List<Grade> grades;

    public Subject(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
        this.grades = new ArrayList<>();
    }

    public void addGrade(double grade) {
        this.grades.add(new Grade(grade));
    }

    public List<Grade> getGrades() {
        return grades;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(name, subject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
