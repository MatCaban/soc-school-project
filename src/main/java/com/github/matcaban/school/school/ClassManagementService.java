package com.github.matcaban.school.school;

import com.github.matcaban.school.members.Student;
import com.github.matcaban.school.members.Teacher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassManagementService {
    private final Map<Teacher, SchoolClass> primaryTeachers = new HashMap<>();
    private final Map<Student, SchoolClass> studentsInClasses = new HashMap<>();

    public void assignTeacherToClass(Teacher teacher, SchoolClass schoolClass) {
        if (teacher == null) {
            throw new RuntimeException("Teacher cannot be null");
        }

        if (schoolClass == null) {
            throw new RuntimeException("Class cannot be null");
        }

        if (schoolClass.getPrimaryTeacher() != null) {
            throw new RuntimeException("Class : " + schoolClass.getName() + " already has primary teacher");
        }

        if (primaryTeachers.containsKey(teacher)) {
            throw new RuntimeException("Teacher: " + teacher.getName() + " is already assign to Class");
        }

        schoolClass.setPrimaryTeacher(teacher);
        primaryTeachers.put(teacher, schoolClass);
    }

    public void unassignTeacherFromClass(SchoolClass schoolClass) {
        if (schoolClass == null) {
            throw new RuntimeException("Class cannot be null");
        }
        if (schoolClass.getPrimaryTeacher() == null) {
            throw new RuntimeException("Class already doesnt have primary teacher");
        }
        Teacher teacher = schoolClass.getPrimaryTeacher();
        schoolClass.setPrimaryTeacher(null);
        primaryTeachers.remove(teacher);
    }

    public void enrollStudent(Student student, SchoolClass schoolClass) {
        if (schoolClass == null) {
            throw new RuntimeException("Class cannot be null");
        }

        if (student == null) {
            throw new RuntimeException("Student cannot be null");
        }

        if (studentsInClasses.containsKey(student)) {
            throw new RuntimeException("Student: " + student.getName() + " is already in class: " + studentsInClasses.get(student).getName());
        }

        schoolClass.addStudent(student);
        studentsInClasses.put(student, schoolClass);
    }

    public void unenrollStudent(Student student, SchoolClass schoolClass) {
        if (schoolClass == null) {
            throw new RuntimeException("Class cannot be null");
        }

        if (student == null) {
            throw new RuntimeException("Student cannot be null");
        }

        if (studentsInClasses.get(student) != schoolClass) {
            throw new RuntimeException("Student is not in this class");
        } else {
            studentsInClasses.remove(student);
            schoolClass.removeStudent(student);
        }
    }
}
