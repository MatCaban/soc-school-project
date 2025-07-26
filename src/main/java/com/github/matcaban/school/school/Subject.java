package com.github.matcaban.school.school;

import com.github.matcaban.school.members.Teacher;

public class Subject {
    private Teacher teacher;
    private String name;

    public Subject(Teacher teacher, String name) {
        this.teacher = teacher;
        this.name = name;
    }
}
