package com.github.matcaban.school.school;

import com.github.matcaban.school.members.Student;
import com.github.matcaban.school.members.Teacher;

import java.util.ArrayList;
import java.util.List;

public class SchoolClass {
    private String name;
    private Teacher primaryTeacher;
    private List<Student> students;

    public SchoolClass(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }



    public Teacher getPrimaryTeacher() {
        return primaryTeacher;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "SchoolClass{" +
                "name='" + name + '\'' +
                ", homeroomTeacher=" + primaryTeacher +
                '}';
    }
}
