package com.github.matcaban.school.members;

import com.github.matcaban.school.school.Grade;
import com.github.matcaban.school.school.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(subjectsList, student.subjectsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subjectsList);
    }
}
