package com.github.matcaban.school.members;

import com.github.matcaban.school.school.Grade;
import com.github.matcaban.school.school.SchoolClass;
import com.github.matcaban.school.school.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends SchoolMember{
    private Map<Subject, List<Grade>> grades;
    private SchoolClass schoolClass;

    public Student(String name, SchoolClass schoolClass) {
        super(name);
        setSchoolClass(schoolClass);
        this.grades = new HashMap<>();
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        if (schoolClass == null) {
            throw new RuntimeException("Class does not exists");
        }
        schoolClass.addStudent(this);
        this.schoolClass = schoolClass;
    }


    public void setGrades(Subject subject, Grade grade) {
        this.grades.putIfAbsent(subject, new ArrayList<Grade>());
        this.grades.get(subject).add(grade);
    }
}
