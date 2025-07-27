package com.github.matcaban.school.members;

import com.github.matcaban.school.school.Grade;
import com.github.matcaban.school.school.SchoolClass;
import com.github.matcaban.school.school.Subject;

import java.util.ArrayList;
import java.util.List;


public class Student extends SchoolMember {
    private SchoolClass schoolClass;
    private List<Subject> subjectsList;

    public Student(String name, SchoolClass schoolClass) {
        super(name);
        this.schoolClass = schoolClass;
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
        return this.subjectsList.stream()
                .flatMap(s -> s.getGrades()
                        .stream()
                        .map(Grade::getGrade))
                .mapToDouble(grade -> grade)
                .average()
                .orElse(0);
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }



    @Override
    public String toString() {
        return super.getName() + " attends " + subjectsList +
                (this.schoolClass != null
                        ? " , is member of class: " + this.schoolClass.getName()
                        : "");

    }
}
