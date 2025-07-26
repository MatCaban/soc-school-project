package com.github.matcaban.school.members;

import com.github.matcaban.school.school.SchoolClass;

public abstract class SchoolMember {
    private String name;


    public SchoolMember(String name) {
        this.setName(name);
    }

    public void setName(String name) {
        if (name.isBlank()) {
            throw new RuntimeException("Name cannot be empty");
        } else {
            this.name = name;
        }
    }

    @Override
    public String toString() {
        return "SchoolMember{" +
                "name='" + name + '\'' +
                '}';
    }
}


