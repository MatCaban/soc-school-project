package com.github.matcaban.school.members;

import com.github.matcaban.school.school.SchoolClass;
import com.github.matcaban.school.school.Subject;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends SchoolMember {
    private List<Subject> subjects;
    private SchoolClass schoolClass;
    public Teacher(String name, SchoolClass schoolClass) {
        super(name);

        this.subjects = new ArrayList<>();
    }


    public SchoolClass getSchoolClass() {
        return schoolClass;
    }
}
