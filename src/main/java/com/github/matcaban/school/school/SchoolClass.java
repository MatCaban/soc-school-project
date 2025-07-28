package com.github.matcaban.school.school;

import com.github.matcaban.school.members.Student;
import com.github.matcaban.school.members.Teacher;

import java.util.ArrayList;
import java.util.List;

public class SchoolClass {
    private Teacher primaryTeacher;
    private String name;
    private List<Student> students;

    public SchoolClass(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    void addStudent(Student student) {
        this.students.add(student);
    }

    void removeStudent(Student student) {
        this.students.remove(student);
    }
    public List<Student> getStudentsList() {
        return students;
    }

    void setPrimaryTeacher(Teacher teacher) {
        this.primaryTeacher = teacher;
    }

    public Teacher getPrimaryTeacher() {
        return primaryTeacher;
    }

    public double averageGradeOfClass() {
        return this.students.stream()
                .mapToDouble(Student::averageGradeOfStudent)
                .average()
                .orElse(0);
    }
}
