package com.github.matcaban.school;

import com.github.matcaban.school.members.Student;
import com.github.matcaban.school.members.Teacher;
import com.github.matcaban.school.school.SchoolClass;

import javax.xml.stream.events.StartDocument;

public class Main {
    public static void main(String[] args) {
        SchoolClass prima = new SchoolClass("prima");
        SchoolClass sekunda = new SchoolClass("sekunda");

        Student anna = new Student("Anna", prima);
        Student jano = new Student("Jano", prima);
        Student peter = new Student("Peter", sekunda);
        Student eva = new Student("Eva", sekunda);

        System.out.println(prima.getStudents());


    }
}
