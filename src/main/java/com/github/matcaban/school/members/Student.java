package com.github.matcaban.school.members;

import com.github.matcaban.school.school.Grade;
import com.github.matcaban.school.school.SchoolClass;
import com.github.matcaban.school.school.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Student extends SchoolMember {
    private Map<Subject, List<Grade>> subjects;
    private SchoolClass schoolClass;
    private List<Subject> subjectsList;

    public Student(String name, SchoolClass schoolClass) {
        super(name);
        this.schoolClass = schoolClass;
        this.subjects = new HashMap<>();
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

    public double getAverageGradePerStudent() {
        return this.subjects.values().stream()
                .flatMap(List::stream)
                .mapToDouble(a -> a.getGrade())
                .average()
                .orElse(0);
    }

    public Map<Subject, Double> getAverageGradePerSubject() {
        return this.subjects.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue()
                                .stream()
                                .mapToDouble(Grade::getGrade)
                                .average()
                                .orElse(0)
                ));
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public void setSubjects(Subject subject, double grade) {
        this.subjects.putIfAbsent(subject, new ArrayList<>());
        this.subjects.get(subject).add(new Grade(grade));
    }

    public Map<Subject, List<Grade>> getSubjects() {
        return subjects;
    }

    @Override
    public String toString() {
        return super.getName() + " attends " + subjects +
                (this.schoolClass != null
                        ? " , is member of class: " + this.schoolClass.getName()
                        : "");

    }
}
