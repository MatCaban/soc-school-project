package com.github.matcaban.school.members;

public abstract class SchoolMember {
    private String name;


    public SchoolMember(String name) {
        this.setName(name);
    }

    public void setName(String name) {
        if (name.isBlank()) {
            throw new RuntimeException("Name cannot be empty");
        } else {
            this.name = formatName(name);
        }
    }

    public String getName() {
        return name;
    }

    private String formatName(String name){
        return name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
    }
}


