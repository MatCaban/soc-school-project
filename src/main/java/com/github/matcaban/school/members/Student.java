package com.github.matcaban.school.members;

import com.github.matcaban.school.school.Grade;
import com.github.matcaban.school.school.Subject;

import java.util.ArrayList;
import java.util.List;


public class Student extends SchoolMember {
    private final List<Subject> subjectsList;

    public Student(String name) {
        super(name);
        this.subjectsList = new ArrayList<>();
    }

    public void addSubjectAndGrade(Subject subject, double grade) {
        if (this.subjectsList.contains(subject)) {
            this.subjectsList.get(this.subjectsList.indexOf(subject)).addGrade(grade);
        } else {
            subject.addGrade(grade);
            this.subjectsList.add(subject);
        }
    }



    public List<Subject> getSubjectsList() {
        return subjectsList;
    }

    public double averageGradeOfStudent() {
        return this.subjectsList.stream()
                .flatMap(s -> s.getGrades()
                        .stream()
                        .map(Grade::getGrade))
                .mapToDouble(grade -> grade)
                .average()
                .orElse(0);
    }
}
